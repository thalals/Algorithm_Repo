import java.io.*;
import java.util.*;

public class Main {
    static String map[][];
    static int gr,gc, pr,pc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        int r = Integer.parseInt(temp[0]);
        int c = Integer.parseInt(temp[1]);

        map = new String [r][c];

        temp = br.readLine().split(" ");

        gr = Integer.parseInt(temp[0]);
        gc = Integer.parseInt(temp[1]);
        pr = Integer.parseInt(temp[2]);
        pc = Integer.parseInt(temp[3]);

        int p_startx = 0;
        int p_starty = 0;

        boolean first = true;

        for(int i=0;i<r;i++){
            temp = br.readLine().split("");
            for(int j=0;j<c;j++) {
                if(temp[j].equals("P") && first){
                    p_startx = i;
                    p_starty = j;
                    first=false;
                }
                map[i][j] = temp[j];
            }
        }

        //solve
        if(solve(p_startx,p_starty))
            System.out.println(0);
        else
            System.out.println(1);

    }

    //x,y -> 배게 시작
    public static boolean solve(int x, int y){

        for(int i= x;i<x+pr;i++){
            for(int j=y; j<y+pc;j++){
                if(!map[i][j].equals("P"))
                    return false;
            }
        }
        return true;
    }



}
