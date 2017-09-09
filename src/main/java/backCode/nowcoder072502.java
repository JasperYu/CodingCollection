package backCode; /**
 * Created by Yu on 2017/7/25.
 */

import java.util.Scanner;

//这个应该是整体排列求最小回文串个数***
//所以下面只是通过30%的用例了
public class nowcoder072502 {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
                String str = in.next();
                String rt = String.valueOf(str.charAt(0));
                System.out.println(helper(rt,1,str,1) );
            return;
    }
    public static int helper(String rt,int index,String str,int current) {
        int count = 0;
        if(index >= str.length()){
            return current;
        }
        StringBuilder sb = new StringBuilder(rt);
        for(int i=0;i<=index;i++)
        {
            sb.insert(i,str.charAt(index));
            //System.out.println("xdde"+sb.toString());
            if(isPar(sb.toString())){
                count =1 ;

                //System.out.println("xd"+1);
                return helper(sb.toString(),++index,str,count);
            }
            sb.deleteCharAt(i);
        }
        sb.append( str.charAt(index));
        //System.out.println("xdd"+1);
        //加入不能变成回文串的话就是认为是之前回文串的结果+1
        return helper(sb.toString(),++index,str,current +1);
    }
    public static boolean isPar(String str) {
        int i = 0;
        int j = str.length()-1;
        for(;i<j;i++,j--){
            if(str.charAt(i)==str.charAt(j)){
                continue;
            }else{
                //System.out.println("xx"+1);
                return false;
            }
        }
        return true;
    }

}
