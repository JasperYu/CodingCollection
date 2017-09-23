package interviewing;

import java.util.Scanner;

/**
 * Created by yu on 17-9-16.
 * BFS
 */
public class WY02 {
    public static  int count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0 ; i < k; i ++){
            count = 0;
            int m = sc.nextInt();
            int n = sc.nextInt();
            String[] matrix = new String[m];
            sc.nextLine();
            for(int p = 0 ; p < m; p ++){
                matrix[p] = sc.nextLine();
//                System.out.println(p);
//                System.out.println( matrix[p].toString());
            }
            String word = sc.nextLine();
            int len = word.length();
//            System.out.println(word);
//            System.out.println(len);
            // 遍历BFS
            for(int p =0 ; p < m; p ++){
                for(int q = 0; q< n;q++){
//                    System.out.println(matrix[p].charAt(q));
//                    System.out.println("word"+word);
                    if(matrix[p].charAt(q)==word.charAt(0))
                    {

                        bfs(matrix,p,q,word,0,m ,n,0);//方向是 1 2 3 0 代表开始
//                        System.out.println("tttt");
                    }

                }
            }

             System.out.println(count);
        }
        return;
    }

    public static void bfs(String[] matrix,int p ,int q, String word, int k,int m ,int n,int direction   ){
        //从+wordlen开始，到-wordlen结束
        if( k  ==word.length()-1 && matrix[p].charAt(q) == word.charAt(k))
        {
//            System.out.println( matrix[p].charAt(q) +"word end "+ word.charAt(k)+ " "+direction);
            count++;
            return;
        }
        if( matrix[p].charAt(q) != word.charAt(k))
        {
            return;
        }
        if(k >= word.length() && matrix[p].charAt(q) != word.charAt(k))
        {
            return;
        }
////
//        System.out.println( matrix[p].charAt(q)+" "+p+" "+q+" " +" "+direction);
        //
        if(direction == 1 )//xiangyou  //xiangxia //xiangyouxia
        {
//            System.out.println( matrix[p].charAt(q) );
            if(q+1<n)
                bfs(matrix,p,q+1,word,k+1,m ,n,1);
            return ;
        }
        if(direction == 2 )//xiangyou  //xiangxia //xiangyouxia
        {
            if(p+1<m)
                bfs(matrix,p+1,q,word,k+1,m ,n,2);
            return ;
        }
        if(direction == 3 )//xiangyou  //xiangxia //xiangyouxia
        {
            if(q+1<n && p+1 <m )
                 bfs(matrix,p+1,q+1,word,k+1,m ,n,3);
            return;
        }
        if(q+1<n)
            bfs(matrix,p,q+1,word,k+1,m ,n,1);
        if(p+1<m)
            bfs(matrix,p+1,q,word,k+1,m ,n,2);

        if(q+1<n && p+1 <m )
            bfs(matrix,p+1,q+1,word,k+1,m ,n,3);
    }
}

