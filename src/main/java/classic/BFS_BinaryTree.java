package classic; /**
 * Created by Yu on 2017/9/10.
 */
//public class TreeNode {
//    int val;
//    dataStructure.TreeNode left;
//    dataStructure.TreeNode right;
//    TreeNode(int x) { val = x; }
//}

import dataStructure.*;
import java.util.*;
public class BFS_BinaryTree {
    //
    public static void main(String[] args){
        TreeNode tn1= new TreeNode(55);
        TreeNode tn2= new TreeNode(45);
        TreeNode tn3= new TreeNode(35);
        TreeNode tn4= new TreeNode(25);
        TreeNode tn5= new TreeNode(15);
        TreeNode tn6= new TreeNode(5);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;

        ArrayList<ArrayList<Integer>> rt = levelOrder(tn1);
        System.out.println(rt);
        //打印结果
    }
    //注意的是 tree的bfs 由一个节点开始遍历
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qe = new LinkedList<TreeNode>();
        qe.add(root);
        //null
        ArrayList<ArrayList<Integer>> rt = new  ArrayList<ArrayList<Integer>>();
        if(root ==null )
            return rt;

        while(!qe.isEmpty()){
            int n = qe.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i = 0 ; i < n ;i ++){
                TreeNode moveNode = qe.poll();
                level.add(moveNode.val);
                if(moveNode.left!=null){
                    qe.add(moveNode.left);
                }
                if(moveNode.right!=null){
                    qe.add(moveNode.right);
                }
            }
            rt.add(level);
        }

        return rt;
    }

}
