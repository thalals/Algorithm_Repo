import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String operator = "+-";

        String temp[] = br.readLine().split("");

        int result = 0;
        int minus_group=0;

        String now_operator="+";
        String number="";

        for(String now : temp){
            //연산자
            if(operator.contains(now)) {
                if(now_operator.equals("+")) {
                    result += Integer.parseInt(number);
                    if(now.equals("-"))
                        now_operator="-";
                }
                else{
                    minus_group+=Integer.parseInt(number);
                    if(now.equals("-")){
                        result-=minus_group;
                        minus_group=0;
                    }
                }
                number="";
            }
            //숫자
            else
                number+=now;
        }
        if(now_operator.equals("+"))
            result+=Integer.parseInt(number);
        else{
            minus_group+=Integer.parseInt(number);
            result-=minus_group;
        }
        System.out.println(result);
    }
}
