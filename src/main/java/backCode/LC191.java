package backCode;

/**
 * Created by Yu on 2017/8/13.
 */
public class LC191 {
    public static void main(String[] args){
        System.out.println(hammingWeight(Integer.MIN_VALUE));
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            if((n & 1) == 1){
                System.out.println(n);
                count++;
            }
            n=n >> 1;
        }
        return count;
    }
}
