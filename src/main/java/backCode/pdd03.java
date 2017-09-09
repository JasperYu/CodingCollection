package backCode; /**
 * Created by Yu on 2017/8/1.
 */

import java.util.Arrays;
import java.util.Scanner;

public class pdd03 {

        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[] h = new int[n];
            for (int i= 0 ; i< n ;i++){
                h[i] =  sc.nextInt();
            }

            if(n<3){
                return;
            }
            // on 找最大的三个和最小的2个
            Long m1 = Long.MIN_VALUE;
            Long m2 = Long.MIN_VALUE;
            Long m3 = Long.MIN_VALUE;
            Long l1 = Long.MAX_VALUE;
            Long l2 = Long.MAX_VALUE;
            for(int i = 0;i < n;i++){
                if(h[i] >= m1){
                    m3 = m2;
                    m2 = m1;
                    m1 = (long)h[i];
                }else if(h[i] < m1 && h[i] >= m2){
                    m3 = m2;
                    m2 = (long)h[i];
                }else if(h[i] < m2 && h[i] > m3){
                    m3 = (long)h[i];
                }

                if(h[i] <= l1){
                    l2 = l1;
                    l1 = (long)h[i];
                }else if(h[i] > l1 && h[i] <= l2){
                    l2 = (long)h[i];
                }
            }


            Arrays.sort(h);
            int max1;
            int max2;
            max1 = (int)(m1 * m2 * m3);
            max2 = (int)(l2 * l1 * m1);
            if (max1 > max2){
                System.out.println(max1);
            }else{
                System.out.println(max2);
            }
            return;
        }
}
