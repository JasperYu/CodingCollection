package dataStructure; /**
 * Created by Yu on 2017/9/11.
 */
import java.util.*;

public class Hash {
    public static void main(String[] args)
    {
        //hashset、hashtable、hashmap
        //hashset是set的hash，不是k-v关系
        //hashmap是hashtable的代替拼  http://www.cnblogs.com/ywl925/p/3865269.html


        //hashset & 相关方法：add(element) contains(element) remove(element) size() isEmpty()  removeall(set)  clear() 遍历可以用for/iterator  注意iterator的形式
        //set中不能存储重复的元素，可以存储null元素。如果需要存储多个重复元素，需要使用List。
        //http://jingyan.baidu.com/article/48206aead61355216bd6b34a.html

        System.out.println("--hashset--");
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        for(Integer i : set){
            System.out.println(i);
        }
        set.remove(1);
        Iterator<Integer> iter = set.iterator();//***
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println(set.contains(2)+" size:"+set.size()+" isEmpty:"+ set.isEmpty());
        //hash map & 相关方法：put(k,v)  get(k) containsKey(k) remove(k)  putall 遍历用Iterator  keyset /  entryset(:getKey getValue)
        //Map中允许key value 为null
        //http://jingyan.baidu.com/article/046a7b3ea2ef24f9c37fa96c.html

        System.out.println("--hashmap--");
        HashMap<Integer,Integer>  map = new HashMap<Integer,Integer>();
        map.put(1,1);
        System.out.println(map.get(2));
        map.put(3,null);
        System.out.println(map.containsKey(2));
        System.out.println(map.get(3));
        System.out.println(map.get(1));
        map.put(1,map.get(1)+1);
        System.out.println(map.get(1));

        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            System.out.println(entry.getKey()+" value: "+ entry.getValue());
        }
    }
}
