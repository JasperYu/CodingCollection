package leetcode;

/**
 * Created by yu on 17-10-2.
 */
public class LC238_ARRAY_2directionpointer_ProductofSelf {
    public int[] productExceptSelf(int[] nums) {
        //方法1,用-log，然后e指数来消除
        //方法2 如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，那么二者相乘就是我们要的结果，所以我们只要分别创建出这两个数组即可，分别从数组的两个方向遍历就可以分别创建出乘积累积数组
        int n = nums.length, right = 1;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; ++i) {
            res[i] = res[i - 1] * nums[i - 1];//先把左边的乘起来
        }
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= right;
            right *= nums[i];//再把右边的乘起来
        }
        return res;
    }
}
