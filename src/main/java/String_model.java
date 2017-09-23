import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yu on 17-9-18.
 */
public class String_model {
    public static void main(String[] args){
        // 这里输入a b c d，然后分别做排列和组合
        String[] arr = new String[3];
        arr[0] = "a";
        arr[1] = "b";
        arr[2] = "a";
       // arr[3] = "d";

        permutation(arr);//全排列，不带重复的4321or代重复的
        combination(arr);//组合，带重复的
        return;
    }
    public static void combination(String[] arr){
        ArrayList<ArrayList<String>> rt = new  ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        int[] visited = new int[arr.length];
        Arrays.sort(arr);

        helper_combination(rt,path,arr,visited);
        System.out.println(rt);

    }
    public static ArrayList<ArrayList<String>> permutation(String[] arr){
        ArrayList<ArrayList<String>> rt = new  ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        int[] visited = new int[arr.length];
        Arrays.sort(arr);
        System.out.println(arr[2]);
        //递归树分析
        helper(rt,path,arr,visited);
        System.out.println(rt);
        return rt;
    }
    public static void helper( ArrayList<ArrayList<String>> rt ,ArrayList<String> path , String[] arr,int[] visited){
        if(path.size()== arr.length){
            rt.add(new ArrayList<String>(path));
            //System.out.println(path);
            return;
        }
        //System.out.println("IN func");
        for(int i = 0 ; i < arr.length;i++){
            //i=i 就是第一层，只有一个
            //System.out.println("IN FOR");
            if(visited[i]== 1 ||(i!=0&& visited[i-1]==1 && arr[i].equals(arr[i-1]))) continue;
            visited[i] =1 ;
            //if(path.contains(arr[i])) continue;// 如果带重复的话那么 a a c  与 a a c 一样，所以
            path.add(arr[i]);
            helper(rt,path,arr,visited);
            visited[i] = 0 ;
            path.remove(path.size()-1);
        }

    }
    public static void helper_combination(ArrayList<ArrayList<String>> rt ,ArrayList<String> path , String[] arr,int[] visited){
        if(!rt.contains(path))
            rt.add(new ArrayList<String>(path));
        //System.out.println(path);
        //System.out.println("IN func");
        for(int i = 0 ; i < arr.length;i++){
            //i=i 就是第一层，只有一个
            //System.out.println("IN FOR");
            if(visited[i]== 1 ||(i!=0&& visited[i-1]==1 && arr[i].equals(arr[i-1]))) continue;
            visited[i] =1 ;
            //if(path.contains(arr[i])) continue;// 如果带重复的话那么 a a c  与 a a c 一样，所以
            path.add(arr[i]);
            helper_combination(rt,path,arr,visited);
            visited[i] = 0 ;
            path.remove(path.size()-1);
        }

    }
}
