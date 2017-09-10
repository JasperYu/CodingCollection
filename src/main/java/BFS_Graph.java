/**
 * Created by Yu on 2017/9/9.
 * This is template class for this proj
 *
 ## Description

 ## Tag /Theme Claasify
 * Union find
 * Trie Tree
 * BFS 、 DFS
 * DP
 * LinkedList
 * Binary Tree 、Divide Conqueer
 * Graph
 * Binary search 、 array
 * String
 * Backtracing



 */

//this is subClass to complete this task
import dataStructure.*;
import java.util.*;
public class BFS_Graph {
    // 分别用邻接表和邻接矩阵实现BFS
    public static void main(String[] args){
        //1.建立图， node模式
        UndirectedGraphNode gn1 = new UndirectedGraphNode(21);
        UndirectedGraphNode gn2 = new UndirectedGraphNode(22);
        UndirectedGraphNode gn3 = new UndirectedGraphNode(23);
        UndirectedGraphNode gn4 = new UndirectedGraphNode(24);
        UndirectedGraphNode gn5 = new UndirectedGraphNode(25);

        gn1.neighbors.add(gn2);
        gn1.neighbors.add(gn3);
        gn2.neighbors.add(gn3);
        gn3.neighbors.add(gn4);
        gn4.neighbors.add(gn5);
        gn5.neighbors.add(gn1);
        /*
        * 1->2->3->4->5
        * |  |  |     |
        * ____________
        */
        bfsNode(gn1);
        //****************
        //****************
        //****************
        //****************
        //2.建立图，array List 邻接表模式
        int n = 5;//node num
        ArrayList[] graph = new ArrayList[n];
        for(int i =0;i< n;i++){
            graph[i] = new ArrayList();
        }
        graph[0].add(3);
        graph[0].add(2);
        graph[1].add(2);
        graph[2].add(3);
        graph[3].add(4);
        graph[4].add(1);
        /*
        * 1->2->3->4->5
        * |  |  |     |
        * ____________
        */
        bfsList(graph);

//        //3. queue
//        Queue qe = new LinkedList();
//        qe.add('a');
//        qe.add('a');
//        qe.add('b');
//        System.out.println(qe.size());
//
//        for(int i =0; i<qe.size();i++){
//            System.out.println(qe.poll());
//            System.out.println(qe.size());
//
//        }
//
//        LinkedList ll = new LinkedList();
//        ll.add(5);
//        ll.add(5);
//        for(int i =0; i<ll.size();i++){
//            System.out.println(ll.poll());
//            System.out.println(ll.size());
//
//        }

    }

    public static void bfsNode(UndirectedGraphNode gn){
        //bfs的要点是将neibourghs 全部遍历入队列，如果队列不为空那么就继续遍历。用xxx标记是否已经被访问过
        //1 .对于判断是否存在环路，可以用遍历之后入度为0的个数是否是节点数来判断*
        // 用入度判断环，遇到环的时候不会遍历 所有节点 ，比如：1 - 2 - 3成环，则因为没有indegree的0的节点所以这三个节点不会入队列，这样就造成了不能遍历的情况，但是可以用来判断是否有环
        //2. 可以用boolean[] flg = new boolean[n] 来判断,对于没有给定大小n的情况用hashset进行判断
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        Queue qe = new LinkedList();
        qe.offer(gn);
        set.add(gn);
        System.out.println(gn.label);//访问第一个点

        while(!qe.isEmpty()){
            gn = (UndirectedGraphNode) qe.poll();//或者Queue<UndirectedGraphNode>
            for(UndirectedGraphNode neighbor : gn.neighbors){
                if(set.contains(neighbor)){
                    continue;
                }
                else{
                    set.add(neighbor);
                    qe.offer(neighbor);
                    System.out.println(neighbor.label);//遍历访问
                }
            }
        }
        //3.如果要返回这样形式的所有节点：return new ArrayList<UndirectedGraphNode>(set);

    }

    public static void bfsList(ArrayList<Integer>[] graph){
        //bfs的要点是将neibourghs 全部遍历入队列，如果队列不为空那么就继续遍历。用xxx标记是否已经被访问过
        //bfs的要点是将neibourghs 全部遍历入队列，如果队列不为空那么就继续遍历。用xxx标记是否已经被访问过
        //1 .对于判断是否存在环路，可以用遍历之后入度为0的个数是否是节点数来判断*
        // 用入度判断环，遇到环的时候不会遍历 所有节点 ，比如：1 - 2 - 3成环，则因为没有indegree的0的节点所以这三个节点不会入队列，这样就造成了不能遍历的情况，但是可以用来判断是否有环
        //2. 可以用boolean[] flg = new boolean[n] 来判断,对于没有给定大小n的情况用hashset进行判断
        HashSet<Integer> set = new HashSet<Integer>();
        Queue<Integer> qe = new LinkedList();
        //可以考虑设置入度，然后从0度开始放入qe，这里直接放入第一个
        set.add(0);
        qe.add(0);
        System.out.println(0);
        int n = graph.length;
        while(qe.size() != 0){
            int num =  qe.poll();
            for(int i=0; i<graph[num].size();i++){
                int pointer =  graph[num].get(i);//get(i) is important function
                if(set.contains(pointer)) continue;//遍历过就不用访问了
                set.add(pointer);
                qe.add(pointer) ;
                System.out.println(pointer);
            }
        }

    }
}
