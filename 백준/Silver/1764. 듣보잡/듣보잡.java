import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        HashMap<String,String> non_listen= new HashMap<>();

        ArrayList<String> list = new ArrayList<>();

        while(n-->0){
            String name = br.readLine();
            non_listen.put(name, name);
        }

        int size =0;

        while(m-->0){
            String name = br.readLine();
            if(non_listen.containsKey(name)) {
                size++;
                list.add(name);
            }
        }

        System.out.println(size);

        Collections.sort(list);
        for(String a : list)
            bw.append(a+"\n");
        bw.flush();
    }

}
