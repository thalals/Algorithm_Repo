import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int map[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int t = Integer.parseInt(temp[1]);

        map = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            temp = br.readLine().split(" ");
            for(int j=1;j<n+1;j++){
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        //dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j]
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        while(t-->0){
            temp = br.readLine().split(" ");
            int x1 = Integer.parseInt(temp[0]);
            int x2 = Integer.parseInt(temp[1]);
            int y1 = Integer.parseInt(temp[2]);
            int y2 = Integer.parseInt(temp[3]);

            int result= solved(x1,x2,y1,y2);
            bw.append(result+"\n");
        }

        bw.flush();
    }

    public static int solved(int x1, int x2, int y1, int y2){
        int result = dp[y1][y2] -(dp[x1-1][y2]+dp[y1][x2-1]) +dp[x1-1][x2-1];

        return result;
    }
}
