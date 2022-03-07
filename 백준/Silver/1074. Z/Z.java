import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] = br.readLine().split(" ");

        n = Integer.parseInt(temp[0]);
        r = Integer.parseInt(temp[1]);
        c = Integer.parseInt(temp[2]);


        solve((int) Math.pow(2, n), 0, 0);

    }
    static void solve(int n, int y, int x) {
        if (y == r && x == c) {
            System.out.println(cnt);
            System.exit(0);
        }
        //rc가 지금 분면에 있으면, 순서대로 1 2 3 4 분면 분할
        if (y <= r && r < (y + n) && x <= c && c < (x + n)) {
            int nn = n / 2;
            solve(nn, y, x);
            solve(nn, y, x + nn);
            solve(nn, y + nn, x);
            solve(nn, y + nn, x + nn);
        } else
            cnt += n * n;
    }

}
