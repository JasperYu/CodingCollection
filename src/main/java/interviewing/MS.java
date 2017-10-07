package interviewing;

/**
 * Created by yu on 17-9-29.
 */
public class MS {
    static int count = 0;
    static int  n = 0;
    public static void  main(String[] args) {
        System.out.println(noOfWays(16));//这个例子可以AC最基本的例子，自己太粗心了，这题基本是属于easy 难度的
    }
//if payment = 16  result = 8
        //注意初始化等
        // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
            // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
          public static  int noOfWays (int payAmount)
          {
                // WRITE YOUR CODE HERE
                // 回溯 {1,4,16,25,...<n}
                n = 0;
                for(int i = 1 ; i < payAmount;i++){
                    if(i*i <= payAmount){
                        n++;
                    }
                }
                int[] arr = new int[n+1];
                for(int i = 1 ; i <= n;i++){
                    arr[i] = i*i;

                    //System.out.println(arr[i]);  这里也是需要处理的。。。
                }
                traceBack(arr,payAmount,0,1);
                return count;
          }

            public static void traceBack(int[] arr,int sum ,int cur,int index){
                if(cur == sum ){
                    count++;
                    //System.out.println(arr[index]);
                    return;
                }
                //System.out.println(index);
                if(cur > sum)  return;
                int tmp = 0;
                for(int i = index ; i <= n;i++){//注意循环的时候不能让cur 变化  所以要赋值为0
                    tmp = cur + arr[i];
//                    cur = cur + arr[i];
                    traceBack(arr,sum,tmp,i);
                }
            }
            // METHOD SIGNATURE ENDS
}
