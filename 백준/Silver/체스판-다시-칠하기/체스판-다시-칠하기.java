import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String map[][];
    static String copymap[][];
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        map = new String[n][m];
        copymap = new String[n][m];

        //map
        for(int i=0;i<n;i++){
            temp = br.readLine().split("");
            for(int j=0;j<m;j++){
                map[i][j] = temp[j];
            }
        }

        //결과값
        int result =Integer.MAX_VALUE;

        //좌표 범위
        for(int i = 0; i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                int min = cnt(i,j);
                result = Math.min(result,min);
            }
        }

        System.out.println(result);
    }

    // 시작좌표 부터 8*8 시작 검, 흰 카운트 return
    public static int cnt(int x, int y){
        mapinit();
        //처음거 그대로
        int a = changeN(x,y);
        mapinit();

        String g ="d";

        //처음거 바꿔서
        copymap[x][y] = blackWhite_change(copymap[x][y]);

        int b = changeN(x,y)+1;

        return Math.min(a,b);
    }

    //값 바꾸기
    public static String blackWhite_change(String a){
        if(a.equals("W"))
            a = "B";
        else a = "W";
        return a;
    }
    //바꾸기 count
    public static int changeN(int x, int y){
        int count=0;

        for(int i=x;i<x+8;i++){
            //세로첫칸 위에꺼랑 비교
            if(i!=x){
                if(copymap[i][y].equals(copymap[i-1][y])){
                    count++;
                    copymap[i][y] = blackWhite_change(copymap[i][y]);
                }
            }

            //가로 비교 첫칸 빼고
            for(int j=y+1;j<y+8;j++){
                if(copymap[i][j].equals(copymap[i][j-1])){
                    count++;
                    copymap[i][j] = blackWhite_change(copymap[i][j]);
                }
            }
        }
        return count;
    }

    //맵 초기화
    public static void mapinit(){
        for(int i=0;i<n;i++)
            System.arraycopy(map[i],0,copymap[i],0,m);
    }
}
