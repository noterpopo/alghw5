import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph graph;
        Scanner scanner=new Scanner(System.in);
        int pointNum=scanner.nextInt();
        int edgeNum=scanner.nextInt();
        ArrayList<Integer> points=new ArrayList<>();
        ArrayList<Edge> edges=new ArrayList<>();
        for(int i=0;i<pointNum;++i){
            points.add(i);
        }
        for(int i=0;i<edgeNum;++i){
            //int sp=i;
            //int ep=i+1;
            int sp=(int)(Math.random()*pointNum);
            int ep=(int)(Math.random()*pointNum);
            edges.add(new Edge(sp,ep));
        }
        graph=new Graph(pointNum,edgeNum,points,edges);

        //Graph graph= GraphUtils.fileToGraph("C:\\Users\\popo\\IdeaProjects\\alghw5\\src\\main\\java\\b2.txt");

        graph.findCocomponentNum();
        ArrayList<Edge> result=GraphUtils.findBridge(graph);
        System.out.println(result.size());
        System.out.println();
//        for(int i=0;i<result.size();++i){
//            System.out.println(result.get(i).sPoint+"-->"+result.get(i).ePoint);
//        }
        result=GraphUtils.findBridgeUFS(graph);
        System.out.println(result.size());
        System.out.println();
//        for(int i=0;i<result.size();++i){
//            System.out.println(result.get(i).sPoint+"-->"+result.get(i).ePoint);
//        }
    }
}
