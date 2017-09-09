package dataStructure;

/**
 * Created by Yu on 2017/9/9.
 */
import java.util.ArrayList;
import java.util.List;

// 另外图的表示是邻接表  ArrayList[] graph = new ArrayList[numCourses];//根据pre建立图,用邻接表，而不是邻接矩阵
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};