package 개인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 송연9_성적처리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int avg = Integer.parseInt(temp[1]);

        for(int i=0;i<n;i++){
            temp = br.readLine().split(" ");
            int number = Integer.parseInt(temp[0]);
            int minus = Integer.parseInt(temp[1]);

            int result = number - minus*5;

            if(result>=avg)
                System.out.println(i+1);

        }
    }
}
