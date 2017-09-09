package backCode; /**
 * Created by Yu on 2017/7/20.
 */
import java.util.ArrayList;
import java.util.List;

public class LC29
{
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String x = in.next();
        //System.out.println(combinationSum3(2,18));
        int b =20;
        System.out.println(b<<2);
        System.out.println(b);
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        int len  =0;
        if(n >=9) len =9;
        else len = n;
        int[] arr = new int[len];
        for(int i = 0;i < len ;i ++){
            arr[i] = i+1;
        }
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        dfs(rt,new ArrayList<Integer>(), n , 0 , k ,arr);//new ArrayList<Integer>()
        return rt;
    }

    public static void dfs(List<List<Integer>> rt, ArrayList<Integer> path, int remain, int start,int len,int[] arr){
        if(path.size() == len && remain == 0){
            rt.add(new ArrayList(path));
            return;
        }

        for(int i = start ; i < arr.length; i ++ ){
            path.add(arr[i]);
            dfs(rt , path, remain - arr[i],i+1,len,arr);
            path.remove(path.size() -1);
        }
    }
}


