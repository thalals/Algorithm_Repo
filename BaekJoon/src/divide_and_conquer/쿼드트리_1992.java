/*
 * 백준 1992번 실버 1
 * 쿼드트리, 분할 정복
 */

package divide_and_conquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 쿼드트리_1992 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		int map[][] = new int[n][n];
		
		for(int i =0;i<n;i++) {
			String str[] = br.readLine().split("");
			for(int j=0;j<n;j++)
				map[i][j] = Integer.parseInt(str[j]);
		}	
		n=n/2;

		divied(map, n*2, 0, 0);

		bw.flush();
		
	}
	
	static void divied(int map[][], int n, int x, int y) throws IOException {
		if(n==1) {
			bw.append(map[y][x]+"");

			return;
		}

		int diviede_n = n;
		
		int flag = map[y][x];	//시작
		boolean check = true;
		
		for(int i=x;i<x+diviede_n;i++) {
			for(int j=y;j<y+diviede_n;j++) {
				if(map[j][i]!=flag) {
					check=false;
					bw.append("(");

					diviede_n = diviede_n/2;
					divied(map,diviede_n,x,y);	//왼쪽
					divied(map,diviede_n,x+diviede_n,y);	//오른쪽	
					divied(map,diviede_n,x,y+diviede_n);	//왼 아래
					divied(map,diviede_n,x+diviede_n,y+diviede_n);	//오 아래
				}
				if(!check)
					break;
			}
			if(!check)
				break;
		}
		if(check)
			bw.append(flag+"");
		else
			bw.append(")");
		
	}
	
}
