package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/5/19.
 */
//这里只要求上升序列，并且是严格上升序列，那么就是判断转折处的上升左长度和上升右长度是多少，
//保证两个上升长度+左边最后一个和右边最后一个都是严格的，那么就可以改变这个数字了
public class Nowcoder3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        n = in.nextInt();
        int[] arr = new int[n+2];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
        }
        arr[0] = Integer.MIN_VALUE;
        arr[n+1] = Integer.MAX_VALUE;

        int[][] acc=new int[n+2][4];//上升左边的长度，上升右边的长度，左边和右边是否相同，是否是递增序列的一员，如果是的话最后记得于右边最长上升序列长度相同
        int count = 0;
        int flg = 3;//0 代表前面递增 1 代表前面递减 否则从新记录为1，就是单调的每次遇到一个转折点，则记录左边最大的递增长度
        //从1 开始，如果比前面大则+1
        for (int i = 1; i <= n ; i++) {
            int tmp;
            if (arr[i] > arr[i - 1]) {
                count++;
                acc[i][3] = 1;
            } else {
                acc[i][1] = count;
                count =1;
            }
            if(arr[i] == arr[i-1] && arr[i] == arr[i+1]){
                acc[i][2] = 1;//表示不能作为严格递增成员
            }
        }
        count = 0 ;
        for (int i = n; i >= 1 ; i--) {
            int tmp;
            if (arr[i] > arr[i - 1]) {
                count++;
            } else {
                acc[i][0] = count;
                count =1;
            }
        }
        int index=0;
        for (int i = 1; i <= n ; i++) {
            int max = 0;
            if(acc[i][1]+acc[i][0] > max){
                max =  acc[i][1]+acc[i][0];
                index = i;
            }
        }

        System.out.println(acc[index][1]+acc[index][0]+1);

    }
}
