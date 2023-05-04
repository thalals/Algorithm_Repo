import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        while(!s.equals(0)){
            String temp[] = s.split("");

            if(temp[0].equals("0"))
                break;
            int end =temp.length-1;
            for(int i=0;i< temp.length;i++){
                if(i==end || Math.abs(i-end)==1 && temp[i].equals(temp[end])){
                    bw.append("yes\n");
                    break;
                }

                if(!temp[i].equals(temp[end])){
                    bw.append("no\n");
                    break;
                }
                end--;
            }
            s = br.readLine();
        }
        
        
        bw.flush();
        bw.close();
        br.close();


    }
}