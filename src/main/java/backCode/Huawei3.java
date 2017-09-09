package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/5/17.
 */
public class Huawei3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String str2 = in.next();
        int n = str.length();
        int m = str2.length();

        char[] rt = new char[m+n+1];
        for(int j=0 ; j< m+n+1;j++){
            rt[j] = '0';
        }

        int flg = 0; //进位
        int i =0;
        for(i=0 ; i< n;i++){
            int si =  ((int) str.charAt(n-i-1) ) - 48 ;//该位

            for(int j=0 ; j< m;j++){
                int sj =  ((int) str2.charAt(m-j-1) ) - 48 ;
             //第一个和str =0的字符数字和str2 的每个数组进行相乘 进行进行仅为运算 运算结果放到s里面
                int v = (si * sj + flg +((int)  rt[ m + n - i - j ]) - 48 ) % 7;

                flg = (si * sj + flg + ((int)  rt[ m + n - i - j ]) - 48 ) / 7;

                String tmp= String.valueOf(v);
                rt[ m + n - i - j ] = tmp.charAt(0);
                //5*5 =25

             //第二个和str = 1的字符象湖。。。。。。。。。运算结果和上一次进行累加

            }

        }
        String tmp= String.valueOf(flg);

        if(flg!=0)
            rt[ 1 ] = tmp.charAt(0);


        int j =0;
        for(j=0 ; j< m+n+1;j++){
            if(rt[j]!='0'){
                break;
            }
        }
        for(;j<m+n+1;j++){
            System.out.print(rt[j]);
        }
        System.out.println();
    }

}
