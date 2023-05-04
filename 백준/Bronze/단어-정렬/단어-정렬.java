import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

class StringClass implements Comparable<StringClass>{
    String a;
    StringClass(String a) {
        this.a = a;
    }

    @Override
    public int compareTo(StringClass o) {
        if(this.a.length() > o.a.length())
            return 1;
        else if(this.a.length() == o.a.length()){
            return this.a.compareTo(o.a);   //a가 문자열상 더 크면(뒤면) return1
        }

        return -1;  //유지
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeSet<StringClass> list = new TreeSet<>();

        while (n-->0)
            list.add(new StringClass(br.readLine()));


        for(StringClass result : list)
            System.out.println(result.a);


    }
}
