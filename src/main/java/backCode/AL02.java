package backCode; /**
 * Created by Yu on 2017/8/25.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class AL02 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int k;
        k = Integer.parseInt(in.nextLine().trim());
        //1+2+3+4+...= n(n-1)/2
        //递增找到n(n-1)/2 < k < (n+1)n/2
        //然后从i + n(n-1)/2 递增找到k
        int n = 1;
        for(n =1 ; n*(n-1)/2<= k ;n++){
        }
        n = n-1 ;
        int rt = 1;
        for(; rt+n*(n-1)/2<k;rt++){
        }
        System.out.println(rt);
    }
}

