package backCode;

import java.util.Scanner;

/**
 * Created by Yu on 2017/4/26.
 */
public class Main {
    public static void main(String[] args){
        int m,n ;
        Scanner sc = new Scanner (System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int num;
        num = sc.nextInt();
        int[] visited = new int [num];//记录连通性
        int[][] racs = new int [num][num];//记录连通性
        int[][] p = new int [num][8]; // 记录线段
        for(int i = 0 ; i < num ;i++)
        {
            p[i][0] = sc.nextInt();
            p[i][1] = sc.nextInt();
            p[i][2] = sc.nextInt();
            p[i][3] = sc.nextInt();
            if(  p[i][0] <=0 || p[i][2] <= 0 )
                p[i][4] = 1;  //表示如果触及左边 则为1
            if(  p[i][0] >= m || p[i][2] >= m  )
                p[i][5] = 1;  //表示如果触及右边边 则为1
            if(  p[i][1] <=0 || p[i][3] <= 0 )
                p[i][6] = 1;  //表示如果触及下 则为1
            if(  p[i][1] >= n || p[i][3] >= n  )
                p[i][7] = 1;   //表示如果触及shang 则为1
        }
        //求node 之间的交点，构建图 （注意要双向构建）
        for(int i = 0 ; i < num ;i++){
            for(int j =0 ;j < num ; j ++){
                double ki = (p[i][3]-p[i][1])/(p[i][2]-p[i][0]);
                double bi = p[i][1] - (ki) *  p[i][0] ;
                double kj = (p[j][3]-p[j][1])/(p[j][2]-p[j][0]);
                double bj = p[j][1] - (kj) *  p[j][0] ;

                if(ki == kj)
                {
                    racs[i][j] = -1;
                    continue;
                }

                double x = (bi-bj) / (ki - kj);
                double y = ki* x + bi;
                if( (y < p[j][3] || y< p[j][1]) && (x < p[j][2] || x< p[j][0]) )
                {
                    racs[i][j] = 1;
                }
                else{
                    racs[i][j] = -1;
                }
            }
        }

        //搜索，看是否同时图上联通，存在两个条件，就是同时有两个边界点,如果连通图触及左边又触及右边或下面则不能
        int[] flg = new int[4];
        int i=0;
        int j=0;
        for( i = 0 ; i < num ;i++){
            for( j =0 ;j < num ; j ++){
                 if (racs[i][j] == 1)
                     break;
            }
        }
        int rt = 0;

        for( i = i ; i < num ;i++){
            for( j =j ;j < num ; j ++){
                if(visited[num]==0)
                    rt = dfs ( racs, i ,j ,p,num,m,  n ,visited);
            }
        }

        System.out.print(rt);
        return ;
    }
    public static int dfs(int[][] racs, int i , int j ,int[][] p,int nums,int m, int n ,int[] v){


        return 1;
    }
}

