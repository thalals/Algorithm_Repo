import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split("-");

        int result= add(temp[0]);

     

        for(int i=1;i<temp.length;i++)
            result-=add(temp[i]);
        System.out.println(result);

    }

    public static int add(String str){
        // \\-> 특수문자
        String tempp[] = str.split("\\+");
        int result = 0;

        for(String s : tempp)
            result+=Integer.parseInt(s);

        return result;
    }
}
