package backCode;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

/**
 * Created by Yu on 2017/8/31.
 */
public class meituan2
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i= 0 ; i< n ;i++){
            arr[i] =  sc.nextInt();
        }
        System.out.println(isTrue(arr,n ));
        return ;
    }
    public static String  isTrue(int arr[], int n ) {
     Arrays.sort(arr);
    System.out.println(arr[0]);
     int sum = 0;
     for(int i =0 ;i<n;i++){
         sum = arr[i] +sum;
     }
     if(arr[n-1]>sum/2) return "No";
     return "Yes";

    }
}
