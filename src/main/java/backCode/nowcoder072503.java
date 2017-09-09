package backCode; /**
 * Created by Yu on 2017/7/25.
 */

import java.util.Scanner;

public class nowcoder072503 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
                String str = in.next();
                int count = 0;
                int max = 0 ;
                for(int i=0; i < str.length();i++){
                    if(str.charAt(i)-'A' == 0 || str.charAt(i)-'T' == 0 ||  str.charAt(i)-'C' == 0  || str.charAt(i)-'G' == 0 ){
                        count ++;
                        if(max < count){
                            max = count;
                        }
                    }else{
                        count = 0;
                    }
                }
                System.out.println(max);
            return;
        }
}
