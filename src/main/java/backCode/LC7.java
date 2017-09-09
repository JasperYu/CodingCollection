package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/7/20.
 */
public class LC7
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         int x = in.nextInt();
        System.out.println(reverse(x));
    }
    public static int reverse(int x) {
        int rt = 0;
        while(x  != 0){
            int tmp = x % 10;
            x = x/10;
            rt = (int)(rt * 10) + tmp;
        }
        return rt;
    }
}
