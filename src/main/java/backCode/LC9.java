package backCode; /**
 * Created by Yu on 2017/7/20.
 */
import java.util.ArrayList;
import java.util.List;

public class LC9
{
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String x = in.next();
         System.out.println(isPalindrome(1000021));
    }
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;//**这个边界判断要注意，负数没有回文串
        if(x < 10) return true;

        int len = 1 ;
        while( x / len >= 10){
            len = len * 10 ;
        }
        int head = 0;
        int tail = 0;
        while(x >0 ){ //注意如果保留>=10的判断 10021 不是回文串，去掉首尾那么就变成002这样就是 x=002 head =0 tail = 2 不相等
            head = x / len;
            tail = x % 10;

            x = x % len ;
            x = x / 10 ;
            len = len / 100;//**注意去头去尾是100
            if(head != tail){
                return false;
            }
        }
        return true;
    }
}


