package backCode; /**
 * Created by Yu on 2017/8/27.
 */

import java.io.*;
public class gg
{

    public static  void main(String[] arg) throws IOException {
    //**读文件
        File in = new File("backCode/A.txt");
        BufferedReader rd = null;
        String[] temp_string =null;
        int num = 0;
        try {
            rd = new BufferedReader(new FileReader(in));
            num = Integer.parseInt(rd.readLine());
            System.out.println(num );
            temp_string = new String[num+1];
            int i =0;
            while ((temp_string[i] = rd.readLine()) != null) {
                i++;
            }
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rd != null) {
                try {
                    rd.close();
                } catch (IOException e1) {
                }
            }
       }
        //**count
        int[] rt = new int[num];
        for(int j = 0; j< num ;j++){
            //**init
            String target=temp_string[j];
            StringBuilder own = new StringBuilder("");
            String clipbord = "";

            System.out.println("---- "+target);
            //分为三块：clip有了直接黏贴，如果后面有前面已经弄好的字符串的子串截取黏贴，否则增加一个
            for(int i=0 ;i< target.length();i++){

                int flg = 0;//判断如果进入赋值

                //clip有了直接黏贴
                int cl = clipbord.length();
                if(i+cl > target.length()) cl=target.length()-i-1;
                if(clipbord.equals( target.substring(i,i+cl))&& clipbord.length()!=0){
                    own.append(target.substring(i,i+clipbord.length()));
                    System.out.println("paste in clip "+own.toString());
                    rt[j] = rt[j] + 1;
                    i = i +clipbord.length() ;
                    continue;
                }

                //如果后面有前面已经弄好的字符串的子串截取黏贴
                int k = own.length();
                if(i+k > target.length()) k=target.length()-i;
                for(;k > 0 ;k--){

                    if(own.toString().contains(target.substring(i,i+k))&& k>1){ //至少2个才核算
                        own.append(target.substring(i,i+k));
                        clipbord = target.substring(i,i+k);
                        rt[j] = rt[j] + 2;
                        i = i + k -1;
                        System.out.println("paste  "+own.toString());
                        flg = 1;
                        break;
                    }  //遍历缩减子串是否包含 如果包含+2 并且i要变动，own要变动
                    //如果i不变动，那么就count+1然后把字符添加进来

                }
                if(flg == 1) { flg = 0 ; continue;}

                //三个都没有的情况下那么就增加一个
                rt[j] = rt[j] + 1;
                own.append(target.substring(i,i+1));
                System.out.println("only  "+own.toString());
            }
            System.out.println("****count***** "+rt[j] );


        }
        try {
            File out = new File("./output_A.txt");
            PrintStream ps = new PrintStream(new FileOutputStream(out));
            for(int j = 0; j< num ;j++){
                ps.append("Case #"+(j+1)+":"+ rt[j]+"\n");// 在已有的基础上添加字符串
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
