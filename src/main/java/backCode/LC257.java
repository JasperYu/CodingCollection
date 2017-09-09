package backCode; /**
 * Created by Yu on 2017/8/6.
 */
import java.util.List;
import java.util.ArrayList;
public class LC257 {

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode(int x) { val = x; }
        }
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.right = new TreeNode(5);
            root.right = new TreeNode(3);

            List<String>  rt = new ArrayList<String>();
            StringBuilder  path = new StringBuilder();
            sum(root,rt,path);
            System.out.println(rt);
            return ;
        }
        public  static  void sum(TreeNode root,  List<String>  rt,StringBuilder  path ) {
            if(root == null ){
                return ;
            }
            System.out.println(path);
            if(root.left != null){
                String sb =String.valueOf(root.val);
                String link = new String("->");
                path.append(sb);
                path.append(link);
                sum(root.left,rt,path);
                path.delete(path.length()-sb.length()-link.length(),path.length()-1);
            }
            if(root.right != null){
                String sb =String.valueOf(root.val);
                String link = new String("->");
                path.append(sb);
                path.append(link);
                sum(root.right,rt,path);
                path.delete(path.length()-sb.length()-link.length(),path.length()-1);
            }
            if(root.left == null && root.right == null ){


                String sb =String.valueOf(root.val);
                path.append(sb);
                rt.add(path.toString());
                path.delete(path.length()-sb.length() ,path.length()-1);
                return ;
            }
        }
}
