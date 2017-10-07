package Google;

/**
 * Created by yu on 17-10-6.
 */
public class LC214_String_Palindrome {
    public static void main(String[] args){
        System.out.println(shortestPalindrome("adcgecdab"));
    }

    public static String shortestPalindrome(String s) {//递归调用

        System.out.println(s+"1");
        int j = 0;

        for (int i = s.length() - 1; i >= 0; i--) {//找到第一个使他不回文的位置

            if (s.charAt(i) == s.charAt(j)) {

                j += 1;// 如果是 如 abca 那么j最后只停再j = 1的地方 ab de ba那么就会j到b
                //如果存在abba这样最后就在j= s.length这里直接返回了！

            }

        }

        if (j == s.length()) {  //本身是回文

            return s;

        }

        String suffix = s.substring(j); // 后缀不能够匹配的字符串

        String prefix = new StringBuilder(suffix).reverse().toString(); // 前面补充prefix让他和suffix回文匹配

        String mid = shortestPalindrome(s.substring(0, j)); //递归调用找 [0,j]要最少可以补充多少个字符让他回文
        System.out.println(mid);
        System.out.println(suffix);

        String ans = prefix + mid  + suffix;

        return  ans;

    }
}
