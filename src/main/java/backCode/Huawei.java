package backCode; /**
 * Created by Yu on 2017/5/17.
 */

import java.util.Scanner;
public class Huawei {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int s = 0;
        String tmp = in.next();
        int n = tmp.length();
        for(int i = 0 ; i<n ;i++){
            s = ((int) tmp.charAt(i) ) - 48  + s;
        }

        tmp = String.valueOf(s);
        String rt = helper(tmp, tmp.length());

        System.out.println(rt.charAt(0));
        return;
    }
    public static String helper(String s,int n ){
        if(s.length() < 2)
            return s;
        n = s.length();
        int irt = 0;
        for(int i = 0 ; i<n ;i++){
            irt = ((int) s.charAt(i) ) - 48  + irt;
        }
        s = String.valueOf(irt);
        return helper(s,n);
    }
}
