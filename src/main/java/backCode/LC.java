package backCode;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by Yu on 2017/7/19.
 */
public class LC
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();  ////******
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int rt = map.get(s.charAt(0));

        for (int i = 0; i < len - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                rt = rt - map.get(s.charAt(i + 1));
            } else {
                rt = rt + map.get(s.charAt(i + 1));
            }
        }

        System.out.println(rt);
    }
}