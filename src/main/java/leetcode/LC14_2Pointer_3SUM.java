package leetcode;

/**
 * Created by yu on 17-10-1.
 */
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
public class LC14_2Pointer_3SUM {
    public List<List<Integer>> threeSum(int[] nums) {
        // 思考 ：暴力解法是 三次方,然后可以用hashmap 变成 平方？---问题是hashmap是点点映射，如果多对一 2 + 3 1+4 比较难映射
        // 参考2/3/4 SUM类通用解法 排序+两个指针去维护
        // 这里用on^2 o1了，可以考虑用hash 做到 onlogn(因为排序，但是要处理冲突hash)
        Arrays.sort(nums);
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < nums.length-2;i++){
            // skip duplicate triples with the same first numebr
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int tar = - nums[i];

            //System.out.println(tar);
            int head = i+1; int tail = nums.length -1 ;
            while(head < tail){
                //注意有正有负，但是sum 如果小于tar ，那么一定应该要加大的数字就是
                if(nums[head] + nums[tail] > tar){

                    //System.out.println("sum》"+nums[head] + nums[tail]);
                    tail--;
                }else if(nums[head] + nums[tail] < tar){
                    head++;

                    //System.out.println("sum《"+nums[head] + nums[tail]);
                }else{
                    List<Integer> choice = new ArrayList<Integer>();
                    choice.add(nums[i]);
                    choice.add(nums[head]);
                    choice.add(nums[tail]);

                    //最最耗时的。。。。找到原因了。。。。。。。。其实采用head++ tail --就能避免重复了不用contains了！！！
                    rt.add(choice);

                    head ++;
                    tail--;
                    // skip duplicate pairs with the same left
                    while (head < tail && nums[head] == nums[head - 1]) {
                        head++;
                    }
                    // skip duplicate pairs with the same right
                    while (head < tail && nums[tail] == nums[tail + 1]) {
                        tail--;
                    }
                }
            }
        }
        return rt;
    }
}
