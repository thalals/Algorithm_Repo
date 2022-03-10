import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        
        //팩토리얼 중 5의 개수만, 5!, 10!. 15!
        System.out.println(n/5 + n/25+n/125);
    }
    


}
