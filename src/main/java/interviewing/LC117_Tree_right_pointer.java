package interviewing;

/**
 * Created by yu on 17-9-17.
 *
 Follow up for problem "Populating Next Right Pointers in Each Node".

 What if the given tree could be any binary tree? Would your previous solution still work?

 Note:

 You may only use constant extra space.
 For example,
 Given the following binary tree,
     1
     /  \
     2    3
     / \    \
     4   5    7
 After calling your function, the tree should look like:
     1 -> NULL
     /  \
     2 -> 3 -> NULL
     / \    \
     4-> 5 -> 7 -> NULL
 */


//我们这里分析下，先画图，然后我们知道
//        这种是一般情况
//          o
//        /  \
//       o   o        A
//     /  \   \
//    o---o----o      B
//   /     \    \
//  o      o     o    C
// 有时候解题思路要考假设或者递推，这时候已经到了特殊情况的C层考虑如何连接，这时候明显需要C层第二个节点的连接信息，这时候只有上层有。
// 然后做 ak 证明 ，ak-1已经得到的地推证明法，所以C层的父母节点是连接的，就是说B是next含有的
// 这里注意的处理方式就是分别维持上一层和下一层的节点指针
import dataStructure.*;

import java.util.ArrayList;

public class LC117_Tree_right_pointer {
    public static void main(String[] args){
        //如果不用o1 时空的话是很方便的
        TreeLinkNode tn1= new TreeLinkNode(55);
        TreeLinkNode tn2= new TreeLinkNode(45);
        TreeLinkNode tn3= new TreeLinkNode(35);
        TreeLinkNode tn4= new TreeLinkNode(25);
        TreeLinkNode tn5= new TreeLinkNode(15);
        TreeLinkNode tn6= new TreeLinkNode(5);

        tn1.left = tn2;
        tn1.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn3.left = tn6;
        connect(tn1);
        System.out.println( );

    }

    public static void connect(TreeLinkNode root) {
        //直接把比较好的贴上来了，要反复复习
        if (root == null) {
            return;
        }

        TreeLinkNode parent = root;
        TreeLinkNode pre;
        TreeLinkNode next;
        while (parent != null) {
            pre = null;
            next = null;
            while (parent != null) {
                if (next == null){//这地方统一处理的好！ 利用一次判空flag&while 找到了第一个非空点！而且不用额外的遍历***
                    next = (parent.left != null) ? parent.left: parent.right;
                }

                if (parent.left != null){
                    if (pre != null) {
                        pre.next = parent.left;
                        pre = pre.next;
                    } else {
                        pre = parent.left;
                    }
                }

                if (parent.right != null) {
                    if (pre != null) {
                        pre.next = parent.right;
                        pre = pre.next;
                    } else {
                        pre = parent.right;
                    }
                }
                parent = parent.next;
            }
            parent = next;
        }
    }
}
