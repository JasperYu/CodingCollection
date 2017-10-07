package interviewing;

import java.util.Scanner;

/**
 * Created by yu on 17-9-27.
 */
public class sushujudge  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();


        int i = 1;
        while(true){
            if(k==0){
                break;
            }
            if(judge(i)==true){
                k--;
            }
            i++;
        }
        System.out.println(i-1);

    }
    public static boolean judge(int num) {
        int n =(int) Math.sqrt(num);
        for(int i = 2 ;i< n;i++){
            if(num % i == 0){

                //System.out.println("--");
                return false;
            }
        }
        int reverse = 0;
        while(num/10!=0){
            reverse = num % 10 * 10;
        }
        reverse = reverse + num;

        //System.out.println(reverse);

        n =(int) Math.sqrt(reverse);
        for(int i = 2 ;i< reverse;i++){
            if(reverse % i == 0){
                return false;
            }
        }

        return true;
    }
}
