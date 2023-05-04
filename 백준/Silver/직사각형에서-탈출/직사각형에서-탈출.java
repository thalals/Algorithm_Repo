import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");

        int x = Integer.parseInt(temp[0]);
        int y = Integer.parseInt(temp[1]);
        int w = Integer.parseInt(temp[2]);
        int h = Integer.parseInt(temp[3]);

        int resultA = Math.min(x,y);
        int resultB = Math.min(w-x,h-y);

        System.out.println(Math.min(resultA,resultB));
    }
}
