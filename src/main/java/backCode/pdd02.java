package backCode; /**
 * Created by Yu on 2017/8/1.
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class pdd02 {

        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[] h = new int[n];
            for (int i= 0 ; i< n ;i++){
                h[i] =  sc.nextInt();
            }

            int m = sc.nextInt();
            int[] w = new int[m];
            for (int i= 0 ; i< m ;i++){
                w[i] =  sc.nextInt();
            }
            Arrays.sort(h);
            Arrays.sort(w);
            int i = 0,j =0;
//            for (  i= 0 ; i< m ;i++){
//                System.out.println(w[i]);
//            }
            while(j < m){
                if(w[j] < h[i]){
                    j++;
                }
                else{
                    System.out.println(m-j);
                    return;
                }
            }
             System.out.println(0);
            return;
        }
}
