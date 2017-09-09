package backCode; /**
 * Created by Yu on 2017/9/8.
 */

import java.util.Scanner;

public class WY2 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
            int ans = 0, x;
            while(k-->0) {
                int n = in.nextInt();
                int[] a= new int[n];
                int count4 = 0 ;
                int count2 = 0 ;
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                    if(a[i]%4==0) count4++;
                    else if(a[i]%2==0) count2++;
                }
                if(n==3 && count4>0) {
                    System.out.println("Yes");
                    continue;
                }
                n = n - count2+1;
                if(count4>= (n+1)/2) // n = c4 + c4 + 1
                {
                    System.out.println("Yes");
                    continue;
                }
                else{
                    System.out.println("No");
                    continue;
                }
            }
        }

}
