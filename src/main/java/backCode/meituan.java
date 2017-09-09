package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/8/31.
 */
public class meituan
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i= 0 ; i< n ;i++){
            arr[i] =  sc.nextInt();
        }
        int k = sc.nextInt();
        //是最长子数组和，审题要清楚

        System.out.println(maxSum(arr,n,k));
        return ;
    }
    public static int  maxSum(int arr[], int n,int k) {

        int cur = 0;
        int max = 0;
        int count = 0;
        for(int i = 0; i<n;i++){
            cur = 0;
            count = 0;
            for(int j = i; j<n;j++){
                cur = cur + arr[j];
                count++;
                if(cur % k==0 && count > max ){
                    max = count;
                }
            }
        }
//        for(int j = 0; j < n; j++) {
//            if(cur >= 0)  {
//                cur += arr[j];
//                count ++;
//            }
//            else {
//                cur = arr[j];
//                count = 1;
//            }
//            if(cur > max && (cur % k ==0)) {
//                max = cur;
//                rt =count;
//            }
//        }
        return max;
    }
}
