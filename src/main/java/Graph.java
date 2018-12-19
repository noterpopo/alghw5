import java.util.ArrayList;

public class Graph {
    public int pointsNum=0;
    public int edgesNum=0;
    public ArrayList<Integer> points=new ArrayList<>();
    public ArrayList<Edge> edges=new ArrayList<>();


    public int ccompoentNum=0;

    public Graph(int pointsNum, int edgesNum, ArrayList<Integer> points, ArrayList<Edge> edges) {
        this.pointsNum = pointsNum;
        this.edgesNum = edgesNum;
        this.points = points;
        this.edges = edges;
    }

    public void display(){
        System.out.println(pointsNum);
        System.out.println(edgesNum);
        for(int i=0;i<edgesNum;++i){
            System.out.println(edges.get(i).sPoint+"-->"+edges.get(i).ePoint);
        }
    }

    public void DFS(int startPos){
        ArrayList<Integer> flagList=new ArrayList<>();
        flagList.clear();
        for(int i=0;i<pointsNum;++i){
            flagList.add(0);
        }
        dfs(startPos,flagList);
    }

    private void dfs(int startPos,ArrayList<Integer> fl){
        fl.set(startPos,1);
        //System.out.println(startPos);
        for(int i=0;i<edgesNum;++i){
            if(edges.get(i).sPoint==startPos&&fl.get(edges.get(i).ePoint)==0){
                dfs(edges.get(i).ePoint,fl);
            }
            if(edges.get(i).ePoint==startPos&&fl.get(edges.get(i).sPoint)==0){
                dfs(edges.get(i).sPoint,fl);
            }
        }
    }

    public void findCocomponentNum(){
        ArrayList<Integer> flagList=new ArrayList<>();
        flagList.clear();
        for(int i=0;i<pointsNum;++i){
            flagList.add(0);
        }
        while (true){
            boolean isFinished=true;
            for(int j=0;j<pointsNum;++j){
                if(flagList.get(j)==0){
                    isFinished=false;
                    dfs(j,flagList);
                    break;
                }
            }
            if(isFinished){
                break;
            }else {
                ccompoentNum++;
            }
        }
    }

}
class Edge {
    public int sPoint;
    public int ePoint;

    public Edge(int sPoint, int ePoint) {
        this.sPoint = sPoint;
        this.ePoint = ePoint;
    }
}
class Node{
    public int parent;
    public int rank;
    public int data;
    public Node(int parent,int rank,int data){
        this.parent=parent;
        this.rank=rank;
        this.data=data;
    }
}
