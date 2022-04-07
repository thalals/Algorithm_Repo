import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        int v = Integer.parseInt(temp[2]);

        int result = v - a;

        if(result%(a-b)==0)
            System.out.println(result/(a-b)+1);
        else
            System.out.println(result/(a-b)+2);
    }
}
