/* 실3
 * 마인크래프트 
 */
package level_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_18111_실3 {

	public static void main(String[] args) throws IOException{
		int n,m,b;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String tmp = br.readLine();
		StringTokenizer str = new StringTokenizer(tmp);
		n=Integer.parseInt(str.nextToken());
		m=Integer.parseInt(str.nextToken());
		b=Integer.parseInt(str.nextToken());
		
		
		int max = 1567856;
		int min = -456456;
		
		int map[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String ss[] = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(ss[j]);
				
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		int time=0;
		int avg_height=0;
		
		for(int height=min;height<=max;height++) {
			
		}
	}

}
