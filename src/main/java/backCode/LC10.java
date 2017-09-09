package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/7/20.
 */
public class LC10
{
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String x = in.next();
        System.out.println(isMatch("aab","baab"));
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
                        dp[i+1][j+1] = dp[i+1][j-1];//**** 后面的匹配可能由后面的字符进行匹配
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);//****
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
