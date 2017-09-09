package backCode; /**
 * Created by Yu on 2017/8/10.
 */
import java.util.ArrayList;
import java.util.List;
public class LC60 {
        public static int count = 0;
        public static List<Integer> rt = new ArrayList<Integer>();
        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //String x = in.next();
            System.out.println(getPermutation(2,2));
        }
        public static String getPermutation(int n, int k) {
            //转化成nlist，然后通过回溯得到all permutation, if count == k的时候返回 list.toString
            int[] arr = new int[n];
            List<Integer> path = new ArrayList<Integer>();
            for(int i = 0 ; i < arr.length ;i++){
                arr[i] = i + 1;
            }
            dfs(arr,path,k,n);
            StringBuffer rts = new StringBuffer();
            for(int i = 0; i < rt.size() ; i ++)
                rts.append(rt.get(i));
            return rts.toString();
        }
        public  static void dfs(int[] arr, List<Integer> path,int k,int n){
            if(path.size() == n ){
                count++;
                if(count == k){
                    rt = new ArrayList<Integer>(path);
                    System.out.println(path);
                }
            }

            for(int i = 0; i < n ; i ++){
                if(path.contains(i+1)){
                    continue;
                }
                path.add(i+1);
                dfs(arr,path,k,n);
                path.remove(path.size()-1);
            }
        }
}
