import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);

        int result = factorial(n);
        System.out.println(result);
    }

    //n<500
    public static int factorial(int n){
        int count=0;

        for(int i=n;i>0;i--){
            if(i%5==0) {
                count+=i/5;
            }
        }

        return n/5 + n/25+n/125;
    }


}
