package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/7/20.
 */
public class LC8
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         String x = in.next();
        System.out.println(myAtoi(x));
    }
    public static int myAtoi(String str){
        str = str.trim();//在“  010 ”挂掉

        if(str.length() == 0 )  return 0;

        int sign = 1;
        int start = 0;
        if( str.charAt(0) == '-' )//统一化处理 采用start标记
        {
            sign = -1;
            start ++;
        }else if (str.charAt(0) == '+')
        {
            start ++;
        }
        long rt = 0;
        for(int i = start; i < str.length() ; i++){
            if (str.charAt(i) < '0' || str.charAt(i) > '9')//在+-2挂掉
                break;
            rt = rt * 10 + str.charAt(i) - '0';  //-'0'
            if (sign == 1 && rt > Integer.MAX_VALUE) //如果不设定为rt为long那么产生很多判断。。。
                return Integer.MAX_VALUE;
            if (sign == -1 &&  (-1) * rt < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return  (int)rt*sign;
    }
}
