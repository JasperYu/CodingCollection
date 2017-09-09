package backCode; /**
 * Created by Yu on 2017/5/17.
 */

import java.util.Scanner;
public class Nowcoder {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n =0 ;
        n = in.nextInt();
        int[] flg = new int [n];
        for(int i  = 0 ;i <n ;i++){
            flg[i]=in.nextInt();
        }

        // 如果两者可能相同，那么大的数字应该是小的数字的2的幂次倍数
        int rt = 1;
        for(int i = 0 ;i <n-1 ;i++){
            int max,min;
            if(flg[i]> flg[i+1] ){
                max = flg[i];
                min = flg[i+1];
            }
            else{
                max = flg[i+1];
                min = flg[i];
            }
            if(min == 0)  break;

            if(max/min % 2 == 0 ) continue;
            else{
                rt = 0;
                break;
            }
        }

        if(rt == 0) System.out.println("NO");
        else System.out.println("YES");

        return;
    }

}
