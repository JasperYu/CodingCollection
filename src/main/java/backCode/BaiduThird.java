package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/4/27.
 */
public class BaiduThird {
    public static void main(String[] args) {
        //可以用快速排序，然后选，这样是On的复杂度  60%的用例
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int f,s,t;
        int max = Integer.MIN_VALUE;
        s = Integer.MIN_VALUE;
        t = Integer.MIN_VALUE;
        for(int j = 0; j < n; j++){
            arr[j] = sc.nextInt();
            if( arr[j] >= max ){
                max = arr[j];
            }else if( arr[j] >= s){
                s = arr[j];
            }else if( arr[j] >= t){
                t = arr[j];
            }
        }
        if(t != Integer.MIN_VALUE) {
            System.out.println(t);
        }else{
            System.out.println(-1);
        }
    }
}

