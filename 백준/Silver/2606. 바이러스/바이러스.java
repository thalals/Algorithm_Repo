import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp[] ;

        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=1;i<n+1;i++)
            list[i] = new ArrayList<>();

        while(t-->0){
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            list[a].add(b);
            list[b].add(a);
        }

        System.out.println(bfs(n));


    }

    public static int bfs(int n){
        int cnt = 0;

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        boolean visit[] = new boolean[n+1];

        deque.add(1);

        while(!deque.isEmpty()){
            int now = deque.poll();
            visit[now] = true;

            for(int next : list[now]){
                if(!visit[next]){
                    deque.add(next);
                    visit[next] = true;
                }
            }
            cnt++;
        }


        return  cnt-1;
    }

}
