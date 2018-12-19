import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/** 
* Graph Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®Ò»ÔÂ 23, 2018</pre> 
* @version 1.0 
*/ 
public class GraphTest {
    Graph graph;
    Scanner scanner=new Scanner(System.in);

@Before
public void before() throws Exception {
    int pointNum=scanner.nextInt();
    int edgeNum=scanner.nextInt();
    ArrayList<Integer> points=new ArrayList<>();
    ArrayList<Edge> edges=new ArrayList<>();
    for(int i=0;i<pointNum;++i){
        points.add(i);
    }
    for(int i=0;i<edgeNum;++i){
        int sp=(int)(Math.random()*pointNum);
        int ep=(int)(Math.random()*pointNum);
        edges.add(new Edge(sp,ep));
    }
    graph=new Graph(pointNum,edgeNum,points,edges);
    //graph= GraphUtils.fileToGraph("C:\\Users\\popo\\IdeaProjects\\alghw5\\src\\main\\java\\b2.txt");

} 

@After
public void after() throws Exception {
    scanner.close();
    System.out.println(graph.ccompoentNum);
} 

/** 
* 
* Method: display() 
* 
*/ 
@Test
public void testDisplay() throws Exception { 
//TODO: Test goes here...
    try{
        Method method=Graph.class.getMethod("display");
        method.setAccessible(true);
        method.invoke(graph);
    }catch (NoSuchMethodError e){

    }catch (IllegalAccessError e){

    }catch (InvocationTargetException e){

    }
} 

/** 
* 
* Method: DFS(int startPos) 
* 
*/ 
@Test
public void testDFS() throws Exception { 
//TODO: Test goes here...
    try{
        Method method=Graph.class.getMethod("DFS",int.class);
        method.setAccessible(true);
        method.invoke(graph,0);
    }catch (NoSuchMethodError e){

    }catch (IllegalAccessError e){

    }catch (InvocationTargetException e){

    }
} 

/** 
* 
* Method: findCocomponentNum() 
* 
*/ 
@Test
public void testFindCocomponentNum() throws Exception { 
//TODO: Test goes here...
    try{
        Method method=Graph.class.getMethod("findCocomponentNum");
        method.setAccessible(true);
        method.invoke(graph);
        ArrayList<Edge> result=GraphUtils.findBridge(graph);
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i).sPoint+"-->"+result.get(i).ePoint);
        }
        result=GraphUtils.findBridgeUFS(graph);
        for(int i=0;i<result.size();++i){
            System.out.println(result.get(i).sPoint+"-->"+result.get(i).ePoint);
        }
    }catch (NoSuchMethodError e){

    }catch (IllegalAccessError e){

    }catch (InvocationTargetException e){

    }
} 


/** 
* 
* Method: dfs(int startPos, ArrayList<Integer> fl) 
* 
*/ 
@Test
public void testDfs() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = Graph.getClass().getMethod("dfs", int.class, ArrayList<Integer>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
