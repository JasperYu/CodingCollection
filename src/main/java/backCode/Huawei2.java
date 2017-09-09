package backCode; /**
 * Created by Yu on 2017/5/17.
 */

import java.util.Scanner;
public class Huawei2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String flg = in.next();
        if (flg.equals("true"))
        {
            helper(str,str.length());
        }
        else{
            helper2(str,str.length());
        }
        return;
    }
    public static char helper(String s,int n ){
        int[] count = new int[256];
        //先遍历一边，计数
        for(int i=0 ; i< n;i++){
            count[s.charAt(i)]++;
        }
        //再遍历一边，每次将遍历到的元素查表，看是否是计数为1 ，如果是则打印+return

        for(int i=0 ; i< n;i++){
            if(count[s.charAt(i)]==1){
                System.out.println(s.charAt(i));
                return s.charAt(i);
            }
        }
        return 'b';//
    }
    public static char helper2 (String s,int n ){
        int[] count = new int[256];
        //先遍历一边，计数
        for(int i=0 ; i< n;i++){
            if(s.charAt(i)< 97)
                count[s.charAt(i) ]++;
            else if(s.charAt(i)>=97 && s.charAt(i) <= 130)
                count[s.charAt(i) - 32]++;
            else
                count[s.charAt(i) ]++;
        }
        //再遍历一边，每次将遍历到的元素查表，看是否是计数为1 ，如果是则打印+return

        for(int i=0 ; i< n;i++){
            if(s.charAt(i)< 97){
                if(count[s.charAt(i)]==1){
                    System.out.println(s.charAt(i));
                    return s.charAt(i);
                }
            }else if(s.charAt(i)>=97 && s.charAt(i) <= 130){
                if(count[s.charAt(i) - 32]==1){
                    System.out.println(s.charAt(i));
                    return s.charAt(i);
                }
            }
            else{
                if(count[s.charAt(i)]==1){
                    System.out.println(s.charAt(i));
                    return s.charAt(i);
                }
            }
        }
        return 'b';//
    }
}
