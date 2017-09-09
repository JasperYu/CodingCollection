package backCode; /**
 * Created by Yu on 2017/4/27.
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BaiduInequalty{
    public static int rst;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();//小于号个数
        rst = 1;
        int[] nums = new int [n];
        for(int i = 0 ;i < n;i++){
            nums[i] = i + 1 ;
        }
        System.out.println(permute(nums,k));//返回的是数量
        return ;
    }
    public static int permute(int[] nums,int k) {
            if (nums == null || nums.length == 0) {
                return rst;
            }

            ArrayList<Integer> list = new ArrayList<Integer>();
            int nk = nums.length-k-1;
            //System.out.println(k+"nk"+nk);//返回的是数量
            helper(list, nums, k, nk);
            return rst;
        }

    public static void helper( ArrayList<Integer> list, int[] nums , int k , int nk){
            if(nk < 0 || k < -2) {
                //System.out.println("nk"+nk+"k"+k);
               // for(int i =0; i< list.size();i++)
               //     System.out.print("+"+list.get(i));
               // System.out.println();
                return;
            }
            if(list.size() == nums.length) {
                rst++ ;
                return;
            }

            for(int i = 0; i < nums.length; i++){
                if(list.contains(nums[i])){
                    continue;
                }
                if(list.size()> 1){
                    int tmp = list.remove(list.size() - 1);
                    //System.out.println(tmp);
                    if(tmp > nums[i] ) {
                        //System.out.println(nums[i] +"<"+tmp+"nk"+nk);//返回的是数量
                        nk--;
                    }  else if(tmp < nums[i]){
                        //System.out.println(nums[i] +">"+tmp +"k"+k);//返回的是数量
                        k--;
                    }
                    list.add(tmp);
                }
                list.add(nums[i]);
                helper( list, nums,k,nk);
                list.remove(list.size() - 1);
            }

        }
}
