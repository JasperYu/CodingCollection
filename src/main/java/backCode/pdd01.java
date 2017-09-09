package backCode; /**
 * Created by Yu on 2017/8/1.
 */

import java.util.Scanner;
public class pdd01 {

        public static void main (String[] args) {
            System.out.println(d());
            return;
        }
        public static  String  d() {
            Scanner sc = new Scanner(System.in);
            String a = sc.next();
            String b = sc.next();
            int m = a.length();
            int n = b.length();
            if(a == null || b == null) return null;
            int len1 = a.length(), len2 = b.length();
            // 结果的位数最多可能是两个乘数位数之和
            int len3 = len1 + len2;
            int[] res = new int[len3];
            int carry = 0, i = 0, j = 0;
            for(i = len1 - 1; i >= 0; i--){
                // 先置carry位为0
                carry = 0;
                for(j = len2 - 1; j >= 0; j--){
                    // 每一位的乘积，等于之前这一位的结果，加上carry，再加上这一位和乘数的乘积
                    int product = carry + res[i + j + 1] + (a.charAt(i) - '0')*(b.charAt(j) - '0');
                    res[i + j + 1] = product % 10;
                    carry = product / 10;
                }
                // 把最后的carry位加上
                res[i + j + 1] = carry;
            }
            StringBuilder resstr = new StringBuilder();
            i = 0;
            // 跳过前面无用的0
            while(i < len3 - 1 && res[i] == 0){
                i++;
            }
            for(; i < len3; i++){
                resstr.append(res[i]);
            }
            return resstr.toString();
        }
}
