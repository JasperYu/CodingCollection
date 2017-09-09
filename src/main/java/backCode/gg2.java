package backCode; /**
 * Created by Yu on 2017/8/27.
 */

import java.io.*;

public class gg2
{

    public static  void main(String[] arg) throws IOException {

        File file = new File("B.txt");
        BufferedReader reader = null;
        String[] tempString =null;
        int num = 0;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            num = Integer.parseInt(reader.readLine());
            num = 3*num;
            System.out.println(num );
            tempString = new String[num+1];
            int i =0;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString[i] = reader.readLine()) != null) {
                // 显示行号
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
       }
       double[] max = new double[num/3];

        for(int j = 0; j< num ;j=j+3){
            String test=tempString[j];
            String[] c = test.split(" ");
            int x1 = Integer.parseInt(c[0]);
            int y1 = Integer.parseInt(c[1]);
            int z1= Integer.parseInt(c[2]);
            c = tempString[j+1].split(" ");
            int x2 = Integer.parseInt(c[0]);
            int y2 = Integer.parseInt(c[1]);
            int z2 = Integer.parseInt(c[2]);
            c = tempString[j+2].split(" ");
            int x3 = Integer.parseInt(c[0]);
            int y3 = Integer.parseInt(c[1]);
            int z3 = Integer.parseInt(c[2]);
            double temp = 0;
            temp = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)+(z1-z2)*(z1-z2));
            if(temp >= max[j/3] ){
                max[j/3] = temp;
            }

            temp = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3)+(z1-z3)*(z1-z3));
            if(temp >= max[j/3] ){
                max[j/3] = temp;
            }

            temp = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2)+(z3-z2)*(z3-z2));
            if(temp >= max[j/3] ){
                max[j/3] = temp;
            }

        }
        for(int j = 0; j< num/3 ;j++){
            max[j]=max[j]/6;
        }
        try {
            File file2 = new File("./output.txt");
            PrintStream ps = new PrintStream(new FileOutputStream(file2));
            for(int j = 1; j<= num/3 ;j++){
                ps.append("Case #"+j+": "+ max[j-1]);// 在已有的基础上添加字符串
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
