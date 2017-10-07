package leetcode;

/**
 * Created by yu on 17-10-1.
 */

//'.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//
//        The matching should cover the entire input string (not partial).
//
//        The function prototype should be:
//        bool isMatch(const char *s, const char *p)
//
//        Some examples:
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "a*") → true
//        isMatch("aa", ".*") → true
//        isMatch("ab", ".*") → true
//        isMatch("aab", "c*a*b") → true

public class LC10_DP_substring {
    public static void main(String[] arg){

        System.out.println(isMatch("aa","a*"));//注意.*可以表示空串 因为可以表示0 个


    }

    public static boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];//这里不匹配说明可以使得X*为0个看是否匹配
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);//否则则模式串当期按和字符串上一个或者字符串上一个，和或模式串当前
                        // 按照*代表0个,让index-2，就是j-1个i+1匹配 ax  = a*
                        // 如果少了 || dp[i][j+1]   再aa a*会输出false  //这里如果进入到这个else里面说明模式串少一个和目前i字符匹配，而如果dp[i][j+1]为真就是说i i-1是一样字符，可以顺下匹配！

                    }
                }
            }
        }
        for (int i = 0 ; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                System.out.println(dp[i][j]);
            }
        }
        return dp[s.length()][p.length()];
    }
}
