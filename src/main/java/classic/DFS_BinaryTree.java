package classic; /**
 * Created by Yu on 2017/9/10.
 */
//public class TreeNode {
//    int val;
//    dataStructure.TreeNode left;
//    dataStructure.TreeNode right;
//    TreeNode(int x) { val = x; }
//}

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 注意树的DFS由两种方法  1. 递归 2. 分治
public class DFS_BinaryTree {
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
        tn3.right = tn6;
        //        55
        //     45     35
        //   25 15      5

        System.out.println("traverse");
        traverse(tn1);

        System.out.println("traversal");
        traverseal(tn1);
        //打印结果
    }
    //Template 1: Traverse
    public static void traverse(TreeNode root){//因为传的是引用！~ 无需return
        if(root==null) return;

        System.out.println(root.val);
        traverse(root.left);

        traverse(root.right);
    }

    //每次遇到题目想下，数据结构是啥，函数参数是啥，算法是啥,返回值是啥
    //Tempate 2: Divide & Conquer
    //注意的是 tree的bfs 由一个节点开始遍历
    //** 分治很重要的，会把每层结果都反回来然后做个整体  下面注释是一般情况！！ resultType！~~
    public static TreeNode traverseal(TreeNode root){
        if(root==null) return root;


        // divide
        TreeNode left = traverseal(root.left);
        TreeNode right = traverseal(root.right);

        //merge 这里实际是做了无用的op了
        root.left= left;
        root.right= right;

        System.out.println(root.val);//如果放到divide之前还是从上到下，如果这里，就是从下到上了！
        return root;
    }

//    public ResultType traversal(TreeNode root) {
//        // null or leaf
//        if (root == null) {
//            // do something and return;
//        }
//
//        // Divide
//        ResultType left = traversal(root.left);
//        ResultType right = traversal(root.right);
//
//        // Conquer
//        ResultType result = Merge from left and right.
//        return result;
//    }
}
