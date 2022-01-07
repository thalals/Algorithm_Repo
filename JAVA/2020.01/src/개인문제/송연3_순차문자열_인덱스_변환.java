package 개인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 송연3_순차문자열_인덱스_변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder builder = new StringBuilder(input);

        int size = input.length();
        while (size-->0){
            builder.setCharAt(size,'#');
            System.out.println(builder.toString());
        }
    }
}
