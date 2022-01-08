package programmers;

import java.io.IOException;

public class level2_kakao문자열압축 {
    public static void main(String[] args) throws IOException {
        String str = "xababcdcdababcdcd";
        System.out.println(check_str(str));
    }
    
    public static int check_str(String str){
        int answer = str.length();
        int size = str.length()/2+1;
        
        //i는 압축개수
        for(int i=1;i<size;i++){
            //첫번째 인덱스부터 압축
            answer=Math.min(answer,count(str,i));
        }
        return answer;
    }
    //size : 압축개수
    public static int count(String str, int size){
        String result ="";

        for(int i=0;i<str.length();i++){
            //자른 문자
            String now = str.substring(i,i+size);
            int index = i+size ;    //다음 비교한 첫인덱스

            int count=1;
            while(index+size<=str.length()&&now.equals(str.substring(index,index+size))){
                count++;
                index+=size;
            }
            i=index-1;

            if(count==1)
                result+=now;
            else
                result+=count+now;

            //남은 문자 뒤에 붙이기
            if(index+size>str.length()){
                result+=str.substring(index);
                break;
            }
        }
        System.out.println(result+" "+result.length());
        return result.length();
    }
}
