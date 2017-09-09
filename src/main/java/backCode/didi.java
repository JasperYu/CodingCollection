package backCode; /**
 * Created by Yu on 2017/8/26.
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class didi {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] rt = str.split(" ");
//            for(int i=0;i<rt.length;i++)
//                System.out.println(rt[i]);
            int n = rt.length;
            int[] arr = new int[n];
            for(int i=0;i<rt.length;i++)
                arr[i] = Integer.parseInt(rt[i]);
            int k = sc.nextInt();
            System.out.println(findKthLargest(arr,k));
        }
    public static int findKthLargest(int[] nums, int k) {
        //排序，第七个-》Arrays.sort()...
        //用到二分法 平摊来说是logn  最坏是on2
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);//找第k大就是找有序数组的倒数第k个  （index = n-k） 5 个里面第二大 应该是第四个小就是n-k+1  ,如果化成下标的话就是n-k 这里在后面用position +1可以去除

    }
    public static int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);//是有序数组的第position个
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {//如果中枢值(第一次为首个元素)位置小于第k目标位置（这时候中枢已经在position这里了，这时候向右边前进）
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }
    public static int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];

        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];//第一个比left（这里还是中枢值）所在值要小的被置换
            while (left < right && nums[left] <= pivot) {
                left++;
            }//第一个大于中枢值（已经不是左值）的被置换
            nums[right] = nums[left];
        }
        //这样一个循环下来，所有比中枢小的全在左边，返回中枢为第几大
        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
    }
}
