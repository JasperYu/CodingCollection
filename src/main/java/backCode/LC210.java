package backCode; /**
 * Created by Yu on 2017/7/20.
 */
import java.util.*;
import java.util.List;
public class LC210
{
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String x = in.next();
        int[][] st = new int[1][2];
        int[] r =new int[2];
        r[0] =1 ;
        r[1] =0;
        st[0] = r;
        System.out.println(findOrder(2, st )[1]);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];//入读
        Queue<Integer> qe = new LinkedList();
        int[] rt = new int[numCourses];
        int count = 0;
        for(int i=0;i<numCourses;i++)//**
            graph[i] = new ArrayList();
        for(int i = 0; i< prerequisites.length;i++ ){//注意是按pre的长度赋值
            degree[prerequisites[i][1]]++;//记录入度个数
            graph[prerequisites[i][0]].add(prerequisites[i][1]);//记录图&可以的走向
        }
        for(int i = 0; i< numCourses;i++ ){
            if(degree[i] == 0 ){
                qe.add(i);
                //
                System.out.println("qwi"+count);
                rt[count] = i;
                count++;
            }
        }

        System.out.println("i"+count);
        while(qe.size()!=0){
            int course =  qe.poll();
            for(int i = 0;i < graph[course].size();i++){
                int pointer =  graph[course].get(i);
                degree[pointer]--;

                System.out.println("i"+count);
                if(degree[pointer]==0){
                    qe.add(pointer);
                    rt[count] = pointer;
                    count++;
                }
            }
        }

        System.out.println("count"+count);
        System.out.println("i"+rt[rt.length-1]);
        if(count != numCourses) return  new int[numCourses];
        System.out.println("i"+rt[rt.length-1]);
        for(int i = 0;i< (rt.length +1)/2;i++){
            int tmp = rt[i];
            rt[i] = rt[rt.length-1-i];
            rt[rt.length-1-i] = tmp;
        }
        return rt;
    }
}
