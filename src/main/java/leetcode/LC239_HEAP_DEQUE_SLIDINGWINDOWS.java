package leetcode;

/**
 * Created by yu on 17-10-2.
 */
import  java.util.Deque;
import  java.util.ArrayList;
import  java.util.ArrayDeque;

public class LC239_HEAP_DEQUE_SLIDINGWINDOWS {
    //维持队首元素是滑动过程中的最大值
    public static void main(String[] args){
        int[] nums = {1,3,-1,-3,5,3,6,7}; int k =3;

        System.out.println( nums);
        System.out.println(maxSlidingWindow(nums,k));
    }
    static  void  inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            //Retrieves and removes the last element of this deque,
            deque.pollLast();//如果有较大的数字进入，则不断移除，保证第一个数字是最大的

        }
        deque.offer(num);//Retrieves and removes the head of the queue represented by this deque
    }

    static  void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public  static  ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        if (nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }

        for(int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);//入队过程中，如果入队大则删去前面all。否则跟随。

            ans.add(deque.peekFirst());
//            System.out.println( nums[i - k + 1]+""+deque);//[3,-1,-3]
            outQueue(deque, nums[i - k + 1]);//滑动过程中每次都把前面的一个筛去
//            System.out.println( nums[i - k + 1]+""+deque);//[-1,-3]
//            1[3, -1]
//            1[3, -1]
//            3[3, -1, -3]
//            3[-1, -3]
//            -1[5]
//                    -1[5]
//                    -3[5, 3]
//            -3[5, 3]
        }

        return ans;

    }
}
