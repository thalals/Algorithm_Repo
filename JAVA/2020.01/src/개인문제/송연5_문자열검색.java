/*
문자열 검색
사용자로부터 입력 받을 문자열의 개수를 입력 받고, 검색할 단어를 입력 받은 후, 앞서 입력 받은 숫자만큼 문자
열을 입력 받는다. 이후 해당 문자열에서 검색어를 포함하는 문자열을 출력하되, 검색어가 존재하지 않을 경우
“None”을 출력하는 코드를 작성하시오.

예시) 입력: 3
ab
abba
oppa
BCabD
출력: abba
BCabD
 */
package 개인문제;

import java.io.*;

public class 송연5_문자열검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String keyword = br.readLine();

        int count=0;
        while (n-->0){
            String example = br.readLine();
            if(example.contains(keyword)) {
                bw.append(example + "\n");
                count++;
            }
        }
        if(count==0){
            System.out.println("NONE");
        }
        else
            bw.flush();
        bw.close();
        br.close();
    }
}
