package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class level2_kakao오픈채팅방 {
    public static void main(String[] args) throws IOException {
        String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        System.out.println(Arrays.toString(solution(record)));

    }
    public static String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String[]> order = new ArrayList<>();

        HashMap<String,String> table = new HashMap<>();

        for(String temp : record){
            String message[] = temp.split(" ");
            if(message[0].equals("Change"))
                table.replace(message[1],message[2]);
            else if(message[0].equals("Enter")){
                table.put(message[1],message[2]);
                order.add(new String[]{message[0],message[1]}); //행동 + userid
            }
            else
                order.add(new String[]{message[0],message[1]}); //행동 + userid
        }

        answer = new String[order.size()];
        for(int i=0;i<answer.length;i++){
            String temp[] = order.get(i);

            if(temp[0].equals("Enter"))
                answer[i] = table.get(temp[1])+"님이 들어왔습니다.";
            else
                answer[i] = table.get(temp[1])+"님이 나갔습니다.";
        }

        return answer;
    }

    
}
