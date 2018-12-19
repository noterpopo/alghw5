import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphUtils {
    public static Graph fileToGraph(String path) {
        int pointsn = 0;
        int edgen = 0;
        ArrayList<Integer> points = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();

        String regx = "\\d+";
        String contents = FileUtil.read(path);
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(contents);
        int count = 0;
        int sp = -1;
        int ep = -1;
        while (matcher.find()) {
            if (count == 0) {
                pointsn = Integer.valueOf(contents.substring(matcher.start(), matcher.end()));
                for (int i = 0; i < pointsn; ++i) {
                    points.add(i);
                }
            } else if (count == 1) {
                edgen = Integer.valueOf(contents.substring(matcher.start(), matcher.end()));
            } else if (count % 2 == 0) {
                sp = Integer.valueOf(contents.substring(matcher.start(), matcher.end()));
            } else {
                ep = Integer.valueOf(contents.substring(matcher.start(), matcher.end()));
                edges.add(new Edge(sp, ep));
            }
            count++;
        }
        return new Graph(pointsn, edgen, points, edges);
    }

    public static ArrayList<Edge> findBridge(Graph graph){
        ArrayList<Edge> result=new ArrayList<>();
        long start=System.currentTimeMillis();
        for(int i=0;i<graph.edgesNum;++i){
            ArrayList<Edge> templist=new ArrayList<>(graph.edges);
            templist.remove(i);
            Graph temp=new Graph(graph.pointsNum,graph.edgesNum-1,graph.points,templist);
            temp.findCocomponentNum();
            if(graph.ccompoentNum!=temp.ccompoentNum){
                result.add(graph.edges.get(i));
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        return result;
    }

    public static ArrayList<Edge> findBridgeUFS(Graph graph){
        ArrayList<Edge> result=new ArrayList<>();
        long start=System.currentTimeMillis();
        for(int i=0;i<graph.edgesNum;++i){
            ArrayList<Edge> templist=new ArrayList<>(graph.edges);
            templist.remove(i);
            Graph temp=new Graph(graph.pointsNum,graph.edgesNum-1,graph.points,templist);
            UFS ufs=new UFS(temp);
            if(graph.ccompoentNum!=ufs.findCocomponentNumUFS()){
                result.add(graph.edges.get(i));
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        return result;
    }
}
