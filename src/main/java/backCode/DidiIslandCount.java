package backCode; /**
 * Created by Yu on 2017/5/7.
 */


import java.util.Scanner;
public class DidiIslandCount
{
    public static int count;
    public static int m;
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] matrix = new int[m+2][n+2];

        for(int i = 0; i < m+2; i++){
            for(int j = 0; j < n+2; j++){
                matrix[i][j] = 0 ;
            }
        }

        for(int i = 0; i < m; i++){
            String tmp = sc.next();
            for(int j = 0; j < n; j++){
               // System.out.println(tmp);
                matrix[i][j] = ((int) tmp.charAt(j) ) - 48;
            }
        }

        count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1)
                {
                    count++;
                    dfs(matrix,i,j);
                }
            }
        }

    }

    public static void dfs(int[][] matrix,int i,int j )
    {
        if(i<0 || i >=m && j <0 || j>=n){
            return;
        }
        if(matrix[i][j] == 1)
        {
            matrix[i][j] = 2;
            dfs(matrix,i,j+1);
            dfs(matrix,i,j-1);
            dfs(matrix,i+1,j);
            dfs(matrix,i-1,j);
        }
    }

}
