package backCode;

/**
 * Created by Yu on 2017/9/10.
 */
import java.util.Scanner;
public class DD2 {
    //FIND UGLY NUMBER
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //丑陋数序列可以拆分为下面3个子列表：
        // (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
        // (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
        // (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
        // 仔细观察上述三个列表，我们可以发现每个子列表都是一个丑陋数***分别乘以2,3,5
        // 整体来说是2 3 5 分别乘以某个还没都检查过的丑陋数然后判断最小
        int[] ugly = new int[n];
        ugly[0] = 1;
        int pointer2 = 0, pointer3 = 0, pointer5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++pointer2];//表示2*第几个丑数，用index2表示  2这个行所用到的 上一个丑数的位置
            if(factor3 == min)
                factor3 = 3*ugly[++pointer3];
            if(factor5 == min)
                factor5 = 5*ugly[++pointer5];
        }
        System.out.println(ugly[n-1]);
    }
}
