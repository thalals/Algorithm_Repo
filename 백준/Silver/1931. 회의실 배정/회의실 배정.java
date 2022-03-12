import java.io.*;
import java.util.*;

class time implements Comparable<time>{
    int start;
    int finish;

    time(int start, int finish){
        this.start = start;
        this.finish = finish;
    }



    @Override
    public int compareTo(time o2) {
        if (this.finish < o2.finish) {
            return -1;
        } else if (this.finish == o2.finish) {
            if (this.start < o2.start)
                return -1;
        }
        return 1;
    }
}
public class Main {
    static int n, r, c, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);

        ArrayList<time> list = new ArrayList<>();

        while(n-->0){
            temp = br.readLine().split(" ");
            list.add(new time(Integer.parseInt(temp[0]),Integer.parseInt(temp[1])));
        }

        Collections.sort(list);

        

        int cnt=0;
        int finish_time = 0;

        for(time a : list){
            if(a.start>=finish_time){
                cnt++;
                finish_time=a.finish;
            }
        }
        System.out.println(cnt);


    }



}
