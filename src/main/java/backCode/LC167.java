package backCode;

/**
 * Created by Yu on 2017/7/20.
 */
public class LC167
{
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String x = in.next();
        System.out.println(myPow(2,-2147483648));
    }
    public static double myPow(double x, int n) {
        double rt = 1;
        if(n < 0){
            n = - n ;
            x = 1.0 /x;
        }
        while( n != 0 ){//注意这里可以有效缩减，代码运行时间
            if(n % 2 == 1)
                rt = rt * x;
            x = x * x;
            if(x == 0) return 0;//说明过于小溢出了
            n = n /2 ;
            System.out.println(x);
        }
        //Input: 2.00000 -2147483648 Output: 1.00000  这里会出问题

        return rt;
    }
}
