package interviewing;

import dataStructure.TreeLinkNode;

/**
 * Created by yu on 17-9-18.
 *
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.


 */
import java.util.*;
public class LC205_HAHSTABLE_STRING {
    public static void main(String[] args){

        System.out.println(isIsomorphic("aab","cca") );

    }

    public static boolean isIsomorphic(String s, String t) {
        // 朴素思考用hashmap 看看是否之前存在映射，并且相同
        HashMap<Character,Character>  ht = new HashMap<Character,Character>();
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
                if(s.charAt(i)!=t.charAt(i)){
                    ht.put(s.charAt(i),t.charAt(i));
                }
            }
        }
        return true;
    }
}
