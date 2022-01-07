package 개인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 송연12_팩토리얼구하기_재귀O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(pac(n));
    }

    public static int pac(int n){
        if(n==1)
            return n;
        else
            return n*pac(n-1);
    }
}
