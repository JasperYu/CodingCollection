package interviewing;

/**
 * Created by yu on 17-9-24.
 */
public class LC004_BinarySearch_K_in_2_sortedArray {

    public static void main(String[] args){


        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9};
        int k = 3;
        int m = arr1.length;
        int n = arr2.length;

        findMedianSortedArrays(arr1,arr2);

    }
    // k 分位的思想是从第k/2开始以k/4, k/8, k/16分别递进一直到k位
    // arr1  .... k/2...
    // arr2  .... k/2...
    //先将两个k/2位置进行比较，如果arr1位置对应的数小，那么就把arr1的start进行调整为k/2，arr2的start还是0，之后再二分查找
    // arr1  ...... k/2+k/4...
    // arr2  ..k/4.....
    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length + nums2.length;
        if(len%2==1)
        {
            return findKthNum(nums1,0,nums2,0,len/2+1);
        }else
        {
            return (findKthNum(nums1,0,nums2,0,len/2+1)+findKthNum(nums1,0,nums2,0,len/2))/2;
        }
    }

    public static double findKthNum(int[] a, int a_start,int[] b, int b_start,int k)
    {
        if (a_start >= a.length) { //如果下发指标都=length 一定取不到了，因为数组最大是length -1
            return b[b_start + k - 1];//
        }
        if (b_start >= b.length) {
            return a[a_start + k - 1];
        }

        if (k == 1) {
            return Math.min(a[a_start], b[b_start]);
        }

        int a_key = a_start + k / 2 - 1 < a.length
                ? a[a_start + k / 2 - 1]
                : Integer.MAX_VALUE;
        int b_key = b_start + k / 2 - 1 < b.length
                ? b[b_start + k / 2 - 1]
                : Integer.MAX_VALUE; //***很有意思的重要思想，感觉如履平地一般！！ 表示如果越过界限后一直再另一个数组里面找，所以这里设定微max值

        if (a_key < b_key) {
            return findKthNum(a, a_start + k / 2, b, b_start, k - k / 2);
        } else {
            return findKthNum(a, a_start, b, b_start + k / 2, k - k / 2);
        }
    }
}
