package 개인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 송연78_key_value_사용자입력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> hashMap = new HashMap<>();

        String input = br.readLine();

        while(!input.equals("exit")){
            String temp[] = input.split(":");
            String key = temp[0];
            int value = Integer.parseInt(temp[1]);

            if(hashMap.containsKey(key))
                hashMap.replace(key,hashMap.get(key)+value);
            else
                hashMap.put(key,value);

            input = br.readLine();
        }

        for(String outkey : hashMap.keySet()){
            System.out.println(outkey+"="+hashMap.get(outkey));
        }

    }
}
