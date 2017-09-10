package backCode;

/**
 * Created by Yu on 2017/9/10.
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
public class DD01 {
    //只AC 30% 超时，个人感觉应该子数组，有就ac
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                    a[i] = sc.nextInt();
            }
            //贪心，只要遍历到某个子区间是成对的那么就割裂

            //最多要遍历n2 对于全数据是不行的
            int count =0;
            int max = 0;
            for(int i = 0;i <n;i++){
                count = 0;
                int start =i;

//                System.out.println('1');
                for(int j = i; j < n;j++){
                    if(isXor(a,start,j)){
                        count++;
                        start = j+1;
                    }

//                    System.out.println('3');
                }
                if(count > max){
                    max =count;
                }
            }
            System.out.println(max);
        }

        public   static boolean isXor(int[] a,int start ,int end) {

//            System.out.println('2');
            if(start==end && a[start]==0) return true;
            HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
            for(int i = start;i<=end;i++){
                if(hm.get(a[i])==null){
                    hm.put(a[i],1);
                }else{
                    hm.put(a[i],hm.get(a[i])+1);
                }
            }
            //遍历判断是否是%2 ==0
            Iterator iter = hm.keySet().iterator();
            while (iter.hasNext()) {
                Object key = iter.next();
                if( hm.get(key)%2!=0){
                    return false;
                }

            }
            return true;
        }

}
