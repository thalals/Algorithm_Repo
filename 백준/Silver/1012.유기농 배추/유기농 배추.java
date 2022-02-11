
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            String temp[] = br.readLine().split(" ");
            int m = Integer.parseInt(temp[0]); //가로
            int n = Integer.parseInt(temp[1]); //세로
            int k = Integer.parseInt(temp[2]); //배추

            int map[][] = new int[n][m];

            while(k-->0){
                temp = br.readLine().split(" ");
                map[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
            }
            bw.append(check_worm(m,n,map)+"\n");
        }

        bw.flush();

    }

    public static int check_worm(int m, int n, int map[][]){
        int count =0;

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    count++;
                    map[i][j] = 0;
                    dfs(i,j, n, m, map);
                }
            }
        }

        return count;
    }
    //인접 배추 삭제
    public static void dfs(int x, int y, int n, int m, int map[][]){
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            //nextX, nextY가 범위를 벗어난다면 그냥 통과한다.
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                continue;
            }
            //다음 방문값 0이면 통과
            if(map[nextX][nextY]==0)
                continue;

            map[nextX][nextY]=0;
            dfs(nextX,nextY,n,m,map);
        }
    }
}
