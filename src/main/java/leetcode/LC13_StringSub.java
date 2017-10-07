package leetcode;

/**
 * Created by yu on 17-10-1.
 */
public class LC13_StringSub {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)  return "";
        String prefix = strs[0];  //加上这个方便循环

        for(int i = 1 ; i < strs.length; i++){
            int j = 0;
            while(j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j))
            {
                j++;
            }

            if (j == 0) return "";
            prefix =  prefix.substring(0,j);
        }

        return prefix;//

    }
}
