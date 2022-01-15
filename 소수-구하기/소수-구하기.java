import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s[] = br.readLine().split(" ");

        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);


        boolean list[] = new boolean[end+1];
        list[0] = true;
        list[1] = true;
        for(int i=2;i<=Math.sqrt(end);i++){
            if(!list[i]){
                check(i,list);
            }
        }

        for(int i=start;i<=end;i++)
            if(!list[i])
                bw.append(i+"\n");
        bw.flush();

    }

    public static void check(int index, boolean[] list){
        for(int i=index+1;i<list.length;i++){
            if(list[i])
                continue;
            if(i%index==0)
                list[i]=true;
        }
    }
}