import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        BigInteger a  = comb(n,m);
        System.out.println(a);
    }

    public static BigInteger comb(int n, int m){
        int t = n-m;
        BigInteger result = new BigInteger("1");

        for(int i=n;i>t;i--){
            result=result.multiply(BigInteger.valueOf(i));
        }

        for(int i=m; i>1 ; i--)
            result=result.divide(BigInteger.valueOf(i));

        return result;
    }
}
