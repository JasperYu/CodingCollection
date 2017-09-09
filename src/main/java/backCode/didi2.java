package backCode; /**
 * Created by Yu on 2017/8/26.
 */
import java.util.Arrays;
import java.util.Scanner;

public class didi2 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] rt = str.split(" ");
//            for(int i=0;i<rt.length;i++)
//                System.out.println(rt[i]);
            int n = rt.length;
            int[] arr = new int[n];
            for(int i=0;i<rt.length;i++)
                arr[i] = Integer.parseInt(rt[i]);

            System.out.println(max(arr,n));
        }
        static int  max(int arr[], int len)
        {
            int maxsum, submax;
            maxsum = submax = arr[0];
            for (int i=1; i<len; i++) {
                if (submax <= 0)
                    submax = arr[i]; //到当前位置之前的sum如果没有用的话就不+上去
                else
                    submax += arr[i]; //到当前位置之前的sum如果没有用的话就不+上去
                if (submax > maxsum) {
                    maxsum = submax;  //更新最大连续子序列和
                }
            }
            return maxsum;
        }
}
