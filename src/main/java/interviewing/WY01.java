package interviewing;

import java.util.Scanner;

/**
 * Created by yu on 17-9-16.
 * 最小
 */
public class WY01 {
    //只通过10%
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stime = new String[n];
        for(int i = 0 ; i < n; i ++){
            stime[i] =sc.next();
        }
//        String s = new String("xx:yx:22");
//
//        String[] sn = new String[3];
//        sn = s.split(":");
//        System.out.println(sn[0]+sn[1]+sn[2]);
        String[][] slist= new String[n][3];
        StringBuffer[][] sblist = new StringBuffer[n][3];
        for(int i = 0 ; i < n; i ++){
            slist[i]= stime[i].split(":");
//
//            System.out.println(slist[i].length);
            for(int j =0 ;j <3 ;j++){
                if(slist[i][j].length()==1)
                    sblist[i][j] = new StringBuffer("0"+slist[i][j]);
                else
                    sblist[i][j] = new StringBuffer(slist[i][j]);
            }
        }
        for(int i = 0 ; i < n; i ++){
            if(sblist[i][0].charAt(0)-'0' >2 ){
                sblist[i][0].setCharAt(0,'0');
            }
            if(sblist[i][0].charAt(1)-'0' >3 && sblist[i][0].charAt(0)-'0' == 2 )
                sblist[i][0].setCharAt(0,'0');

            if(sblist[i][1].charAt(0)-'0' >6 )
                sblist[i][1].setCharAt(0,'0');
            if(sblist[i][1].charAt(1)-'0' !=0 &&  sblist[i][1].charAt(0)-'0' ==6 )
            {
                sblist[i][1].setCharAt(0,'0');
            }

            if(sblist[i][2].charAt(0)-'0' >6 )
                sblist[i][2].setCharAt(0,'0');
            if(sblist[i][2].charAt(1)-'0' !=0 &&  sblist[i][2].charAt(0)-'0' ==6 )
            {
                sblist[i][2].setCharAt(0,'0');
            }
        }

        for(int i = 0 ; i < n; i ++){

            System.out.println(sblist[i][0]+":"+sblist[i][1]+":"+sblist[i][2]);
        }

        return;
    }
}

