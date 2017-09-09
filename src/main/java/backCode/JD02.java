package backCode; /**
 * Created by Yu on 2017/9/8.
 */

import java.util.Scanner;

public class JD02 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int count = 0;
            int sqrtn= (int) Math.floor(Math.sqrt(n));


            //注释是正确思路：因为从1 开始**这个条件太重要了，所以应该 3^10 = 9^5 = (3^5)^2  到基数的最大幂次，然后找
            //该幂次的因子，最后这个是一个组合，比如这样的情况下就是3C2
            //这样的话是 O(N*logN*M) M为最大因子个数
            for(int i = 1; i <= sqrtn; i++){
                double left =i;
                for(int b =1 ;b <=n;b ++){
                    left=left*i;
                    for(int c = i; c<= n ;c++){//
                        for(int d =1 ;d <= n;d ++){
                            if(left==Math.pow(c,d)){
                                count ++;
                            }

                        }
                    }
//
//                    for(int a = 1; a <= n ;a++){
//                        double left =a;
//                        for(int b =1 ;b <=n;b ++){
//                            left=left*a;
//                            for(int c = 1; c<= n ;c++){
//                                double right =c;
//                                for(int d =1 ;d <=n;d ++){
//                                    right=right*c;
//                                    if(left==right){
//                                        count ++;
//                                    }
//
//                                }
//                            }
//                    double rt = Math.pow(a,b);
//                    if(Math.sqrt(a) > (int)Math.sqrt(a)){
//                        continue;
//                    }

                }
            }
            System.out.println(count+(n-sqrtn)*n);

        }
//        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int k = in.nextInt();
//            int n = (int)(sqrt(8*k+1)-1)/2;
//            if(n*n<2*k) n=n+1;
//            System.out.println(n);
//        }
//        public static int sqrt(int x) {
//            int low = 0;
//            int high = x;
//            while(low<=high){
//                long mid = (long)(low + high)/2;
//                if(mid*mid < x)
//                    low = (int)mid + 1;
//                else if(mid*mid > x)
//                    high = (int)mid - 1;
//                else
//                    return (int)mid;
//            }
//            return high;
//        }

}
