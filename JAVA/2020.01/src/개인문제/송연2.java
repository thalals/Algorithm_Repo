/*
2. 분리한 문자열의 첫 번째 문자 출력하기
사용자로부터 임의의 문자열을 입력 받아 공백을 기준으로 분리한 후, 분리된 문자열의 첫 번째 글자만 모아서 출
력하는 코드를 작성하시오.

예시) 입력: ABC DEF GHI
출력: A,D,G
 */
package 개인문제;

import java.io.*;

public class 송연2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        for(int i=0;i< temp.length;i++){
            bw.append(temp[i].charAt(0));
            if(i!= temp.length-1)
                bw.append(",");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
