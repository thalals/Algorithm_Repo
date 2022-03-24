import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] ;
        int n = Integer.parseInt(br.readLine());
        String k;
        String v;

        while(n!=0){
            TreeMap<String,String> list = new TreeMap<>();
            for(int i=0;i<n;i++) {
                v = br.readLine();
                k = v.toLowerCase(Locale.ROOT);
                list.put(k,v);
            }

            bw.append(list.firstEntry().getValue()+"\n");
            n = Integer.parseInt(br.readLine());
        }

        bw.close();




    }

}
