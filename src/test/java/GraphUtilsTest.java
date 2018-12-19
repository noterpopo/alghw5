import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/** 
* GraphUtils Tester. 
* 
* @author <Authors name> 
* @since <pre>Ê®¶þÔÂ 2, 2018</pre> 
* @version 1.0 
*/ 
public class GraphUtilsTest {

    Graph graph;

    @Before
    public void before() throws Exception {
        graph= GraphUtils.fileToGraph("C:\\Users\\popo\\IdeaProjects\\alghw5\\src\\main\\java\\mediumDG.txt");
    }

    @After
    public void after() throws Exception {
        System.out.println(graph.ccompoentNum);
    }

    /**
* 
* Method: fileToGraph(String path) 
* 
*/ 
@Test
public void testFileToGraph() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findBridge(int num, Graph graph) 
* 
*/ 
@Test
public void testFindBridge() throws Exception { 
//TODO: Test goes here...
    try{
        Method method=GraphUtils.class.getMethod("display");
        method.setAccessible(true);
        method.invoke(graph);
    }catch (NoSuchMethodError e){

    }catch (IllegalAccessError e){

    }catch (InvocationTargetException e){

    }
} 


} 
