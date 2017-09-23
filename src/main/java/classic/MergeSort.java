package classic;

/**
 * Created by yu on 17-9-19.
 */
//http://www.cnblogs.com/chengxiao/p/6194356.html
public class MergeSort {
    public static void main(int[] A) {
        // use a shared temp array, the extra memory is O(n) at least
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }

    private static void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int left = start, right = end;
        int mid = (start + end) / 2;
        //分
        mergeSort(A, start, mid, temp);
        mergeSort(A, mid+1, end, temp);
        //治  所以注意分治不一定是要最后==什么！！
        merge(A, start, mid, end, temp);
    }

    private static void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid+1;
        int index = start;

        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        //将继续没有merge的merge
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }

        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }

}
