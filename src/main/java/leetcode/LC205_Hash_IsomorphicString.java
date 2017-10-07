package leetcode;

/**
 * Created by yu on 17-10-2.
 */
import java.util.HashMap;
import java.util.HashSet;
public class LC205_Hash_IsomorphicString {
    public static void main(String[] args){
       System.out.print( isIsomorphic("aa","ab"));
    }

    public static boolean isIsomorphic(String s, String t) {
        // 朴素思考用hashmap 看看是否之前存在映射，并且相同
        HashMap<Character,Character>  ht = new HashMap<Character,Character>();
        HashSet<Character> hs = new HashSet<Character>();
        int len = s.length();
        int t_len = t.length();
        if(len != t_len){
            return false;
        }
        for(int i =0 ; i < len ;i++){
            if (ht.containsKey(s.charAt(i)) ) {
                if (ht.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }else{
                if(!hs.contains(t.charAt(i))){//注意aa ab  a 映射a 了 a就不能映射b反之也对！，所以如果一个新映射的一定不能映射到已经再set里面的
                    ht.put(s.charAt(i),t.charAt(i));
                    hs.add(t.charAt(i));
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
    //下面是超过75%的
    //     int[] m = new int[512];
    // for (int i = 0; i < s1.length(); i++) {
    //     if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
    //     m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
    // }
    // return true;
}
