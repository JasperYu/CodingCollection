package backCode; /**
 * Created by Yu on 2017/9/8.
 */

import java.util.Scanner;
public class JD01 {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int k = in.nextInt();
            int n = (int)Math.ceil((Math.sqrt(8*k+1)-1)/2);
            System.out.println(n);
        }
//    Scanner in = new Scanner(System.in);
//    int k = in.nextInt();
//    //int n = (int)Math.ceil((Math.sqrt(8*k+1)-1)/2);
//    int i =1;
//    k = 2*k;
////            while(i <=k || i+1 <=k){
////                i = i*2;
////            }
//
//    int j =1;
//            for( j= 1; j*j < k;j++){
//
//    }
//
//            System.out.println(j-1);
////
////            System.out.println(n);
}
