package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/5/19.
 */
public class Nowcoder2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        arr[n] = Integer.MAX_VALUE;
        int count = 0;
        int flg = 3;//0 代表前面递增 1 代表前面递减
        for (int i = 0; i < n ; i++) {
            int tmp;
            if (arr[i] >= arr[i + 1]) {
                tmp = 1;
            } else {
                tmp = 0;
            }

            if(flg == 3){
                flg = tmp;
                count++;
            }else if(flg != tmp || i == 0) {
                flg = 3;
                continue;
            } else
                continue;

        }
        System.out.println(count);

    }
}
