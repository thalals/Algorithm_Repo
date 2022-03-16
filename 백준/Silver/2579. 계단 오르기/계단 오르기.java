import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);

        //갈수 있는 2가지 경우 중 더 큰값
        //이전에 연속된 칸을 선택하면 무조건 +2
        //2가지 경우 -> 전에칸을 밝을거냐, 점프뛸거냐
        //dp[n] = Math.max(dp[n-3]+arr[n-1], dp(n-2)  +  arr[n]
        int arr[] = new int[n+2];
        int dp[] = new int [n+2];

        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(br.readLine());


        dp[0] = arr[0];
        dp[1] = arr[0]+arr[1];
        dp[2]= Math.max(arr[0]+arr[2], arr[1]+arr[2]);

        for(int i=3;i<n;i++)
            dp[i] = Math.max(dp[i-3]+arr[i-1], dp[i-2])  +  arr[i];

        System.out.println(dp[n-1]);
    }



}
