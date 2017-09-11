/**
 * Created by Yu on 2017/9/10.
 */

//this is temperlate of ... include 1. sequence 2. matrix 3. backup
public class DynamicProgramming {
    public static void main(String[] args){
        //
        fshow();
    }
    //triangle

    public static void fshow(){
        int n = 20;
        int[] f= new int[n];
        //initialized
        f[0] = 0;
        f[1] = 1;
        System.out.println("-----这 是 斐波那契数列-----");
        //递推
        for(int i= 2 ; i< n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        for(int i= 0 ; i< n; i++){
            System.out.print("[i]:"+f[i]+"+");
        }
    }
}
