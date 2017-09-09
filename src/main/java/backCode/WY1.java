package backCode; /**
 * Created by Yu on 2017/9/8.
 */

import java.util.Scanner;

public class WY1 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int N = in.nextInt();
            StringBuffer rt = new StringBuffer();

            int  own = 0;
            //N 表示剩余的  own表示现在有的
            int remain = N;
            while(remain!=0) {
                //奇数用1个1，然后多个2
                remain = N - own;
                if (remain % 2 != 0) {

                    rt.append("1");
                    if(remain<own*2+1 +own)
                    {
                        own = N;
                        remain = N - own;
                    }else{
                        own = own *3+1;
                        remain = N - own;
                    }
                }
                if (remain % 2 == 0 && N!=own ){

                    rt.append("2");
                    if(remain<own*2+2 +own)
                    {
                        own = N;
                        remain = N - own;
                    }else{
                        own = own *3+2;
                        remain = N - own;
                    }
                }
                //偶数用多个2
                //
            }

            System.out.println(rt.toString());
        }

}
