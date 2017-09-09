package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/4/27.
 */
public class BaiduInterTest
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0 ){
            t--;
            String str = sc.next();
            //str = "0011100";
            int n = str.length();
            int s = 0;
            int e = n-1;
            int count =0;
            while(s < e){

                if(str.charAt(s) == '1' &&  str.charAt(e) == '0'){
                    count ++;
                    s++;
                    e--;
                    continue;
                }
                if(str.charAt(s) == '0'){ //1000000111110111010100001010100 注意如果这两个判断再前面再第16位（从1数）就会先判断0  1 然后都++，然后再交换了，就多记了
                    s++;
                }
                if(str.charAt(e) == '1'){
                    e--;
                }
            }
            System.out.println(count);
        }

        return ;
    }

}
