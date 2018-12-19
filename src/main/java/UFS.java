import java.util.ArrayList;

public class UFS {
    ArrayList<Node> nodes=new ArrayList<>();
    Graph graph;
    public UFS(Graph graph){
        this.graph=graph;
        for(int i=0;i<graph.pointsNum;++i){
            nodes.add(new Node(i,0,i));
        }
    }
    public int getParent(int n){
        if(nodes.get(n).parent==n){
            return n;
        }
        return nodes.get(n).parent=getParent(nodes.get(n).parent);
    }
    public void union(int t1,int t2){
        t1=getParent(t1);
        t2=getParent(t2);
        if(nodes.get(t1).rank>nodes.get(t2).rank){
            nodes.get(t2).parent=t1;
        }else if(nodes.get(t1).rank<nodes.get(t2).rank){
            nodes.get(t1).parent=t2;
        }else {
            nodes.get(t1).parent=t2;
            nodes.get(t2).rank++;
        }
    }
    public int findCocomponentNumUFS(){
        int result=0;
        for(int i=0;i<graph.edgesNum;++i){
            union(graph.edges.get(i).sPoint,graph.edges.get(i).ePoint);
        }
        for(int i=0;i<graph.pointsNum;++i){
            if(nodes.get(i).parent==i){
                result++;
            }
        }
        return result;
    }
}
