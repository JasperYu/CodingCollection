package leetcode;

/**
 * Created by yu on 17-10-1.
 */
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
public class LC17_Backtracking_PHONENUM {
    public List<String> letterCombinations(String digits) {
        //方法2有点类似于递归树分析，每层都是一个数字点/方法1
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if(digits.length() == 0) return ans;
        ans.add("");
        //循环形式的回溯！！！！！！！
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));//取第几位数字
            while(ans.peek().length()==i){//判断是否满足取出后 位数的长度 先进先出
                String t = ans.remove();//
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }
}
