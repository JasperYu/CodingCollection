package leetcode;

/**
 * Created by yu on 17-10-1.
 */
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
public class LC19_2POINTER_4SUM {

    public List<List<Integer>> fourSum(int[] nums, int target) { ///注意0只是一个target
        Arrays.sort(nums);
        //立方解法
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        for(int j = 0; j < nums.length -3 ;j ++){
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            for(int i = j +1 ; i < nums.length-2;i++){
                // skip duplicate triples with the same first numebr
                if (i != j + 1 && nums[i] == nums[i - 1])//1.要j遍历的时候不和前面重复  2. 要j固定时候i遍历的时候不和前面重复
                    continue;


                //System.out.println(tar);
                int head = i+1; int tail = nums.length -1 ;
                while(head < tail){
                    //注意有正有负，但是sum 如果小于tar ，那么一定应该要加大的数字就是
                    int sum = nums[head] + nums[tail]+ nums[i] + nums[j];
                    if( sum > target){

                        //System.out.println("sum》"+nums[head] + nums[tail]);
                        tail--;
                    }else if(sum  < target){
                        head++;

                        //System.out.println("sum《"+nums[head] + nums[tail]);
                    }else{
                        List<Integer> choice = new ArrayList<Integer>();
                        choice.add(nums[j]);
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
    }

        return rt;
    }
}
