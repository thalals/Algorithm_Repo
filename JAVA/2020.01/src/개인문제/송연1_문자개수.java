/*
1. 문자열을 구성하는 문자의 개수 세기
사용자로부터 임의의 문자열을 입력 받아 해당 문자열을 구성하는 문자들 및 각 문자의 개수를 출력하는 코드를
작성하시오.

입력: 가가가bbbbcc#
출력: 가3b4c2#1
 */
package 개인문제;

import java.io.*;

public class 송연1_문자개수 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();


        while(input.length()>0){
            String a = input.substring(0,1);
            bw.write(a);
            int totalsize = input.length();
            input = input.replace(a,"");
            int nowsize = input.length();
            bw.write(Integer.toString(totalsize-nowsize));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
