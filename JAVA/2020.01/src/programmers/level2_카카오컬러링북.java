package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class dot{
    int x;
    int y;

    dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class level2_카카오컬러링북 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m=6;
        int n=4;
        int picture[][] = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}};

        System.out.print(Arrays.toString(solution(m,n,picture)));
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean visit[][] = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j])
                    continue;
                else if(picture[i][j]==0){
                    visit[i][j] = true;
                    continue;
                }
                //return areaSize
                maxSizeOfOneArea=Math.max(maxSizeOfOneArea,bfs(i,j,picture[i][j],picture, visit,1));
                numberOfArea+=1;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    //count = areaSize
    public static  int bfs(int x,int y, int AreaNumber, int map[][], boolean visit[][],int count){
        Queue<dot> queue = new ArrayDeque<>();
        queue.add(new dot(x,y));

        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, 1, 0, -1 };

        while(!queue.isEmpty()){
            dot now = queue.poll();
            visit[now.x][now.y] = true;

            for(int i=0;i<4;i++){
                int nextx = now.x + dx[i];
                int nexty = now.y + dy[i];

                if (nextx < 0 || nextx >= visit.length || nexty < 0 || nexty >= visit[0].length)
                    continue;
                
                //방문한적 없고, 같은영역이면
                if(map[nextx][nexty]==AreaNumber && !visit[nextx][nexty]){
                    queue.offer(new dot(nextx,nexty));
                    visit[nextx][nexty]=true;
                    count+=1;

                }
            }
        }

        return count;

    }
}
