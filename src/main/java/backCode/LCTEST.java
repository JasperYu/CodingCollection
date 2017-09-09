package backCode; /**
 * Created by Yu on 2017/8/13.
 */
import java.util.*;
import java.util.List;
public class LCTEST {
    public static void main(String[] arg){
        TreeNode rt = new TreeNode(2)     ;
                rt.left =new TreeNode(3);
        System.out.println(rt);
        System.out.println( sumNumbers(rt));
        return;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
  }
        public static int sumNumbers(TreeNode root) {
            //traverse  rt,最后把把rt处理一下
            //

            System.out.println(root);
            List<List<Integer>> rt = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();

            System.out.println("path out"+path);

            System.out.println("rt out"+rt);
            dfs(root, path, rt);
            //处理rt
            int sum = 0;
            int n = rt.size();
            for(int i =0; i < n ; i++){
                int size = rt.get(i).size();

                System.out.println( rt.get(i));
                int pathsum = 0;
                for(int j  = 0 ; j < size; j ++){
                    pathsum = pathsum + rt.get(i).get(j)*(int)Math.pow(10,size-j -1);
                }
                System.out.println(pathsum);
                sum = pathsum +sum;
            }
            return sum;

        }
        public static void  dfs(TreeNode root, List<Integer> path,List<List<Integer>> result){
            System.out.println("path"+path);

            System.out.println("result"+result);
            if(root ==null) return ;
            path.add(root.val);
            if(root.left != null)
            {
                dfs(root.left, path, result);
                //[[5,4,11,7,2],[5,4,11,7,2,8,13,4,5]] 这是不remove的结果，注意java 的传递！

                path.remove(path.size()-1);
            }
            if(root.right != null)
            {
                dfs(root.right, path, result);
                //[[5,4,11,7,2],[5,4,11,7,2,8,13,4,5]] 这是不remove的结果，注意java 的传递！

                path.remove(path.size()-1);
            }
            if(root.right == null && root.left==null)
            {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
}
