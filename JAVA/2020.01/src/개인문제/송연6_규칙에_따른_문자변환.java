package 개인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 송연6_규칙에_따른_문자변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("A",4);
        hashMap.put("E",3);
        hashMap.put("G",6);
        hashMap.put("I",1);
        hashMap.put("O",0);
        hashMap.put("S",5);
        hashMap.put("Z",2);

        String input = br.readLine();
        StringBuilder builder = new StringBuilder(input);

        for(int i=0;i<input.length();i++){
            String key = input.substring(i,i+1);
            if(hashMap.containsKey(key))
                builder.setCharAt(i,Character.forDigit(hashMap.get(key),10));
        }
        System.out.println(builder.toString());
    }
}
