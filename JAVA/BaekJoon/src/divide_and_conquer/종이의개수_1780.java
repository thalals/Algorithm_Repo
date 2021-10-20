/*
 * 실버2 백준 1780 분할정복
 * 종이의 개수
 * 
 */
package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 종이의개수_1780 {

	static int a=0, b=0, c=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		
		for(int i =0;i<n;i++) {
			String a[] = br.readLine().split(" ");
			
			for(int j=0;j<n;j++)
				map[i][j] = Integer.parseInt(a[j]);
		}
		
		divide(map,n,0,0);
		
		br.close();
		
		System.out.println(a+"\n"+b+"\n"+c);
	}
	
	public static void divide(int map[][], int n, int x, int y) {
		if(n==1) {
			if(map[y][x]==-1)
				a++;
			else if(map[y][x]==0)
				b++;
			else if(map[y][x]==1)
				c++;
			return;
		}
		
		int flag= map[y][x];
		boolean check = false;
		
		
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(flag!=map[j][i]) {
					check=true;
					n=n/3;
					divide(map,n,x,y);				//1
					divide(map,n,x,y+n);			//2
					divide(map,n,x,y+2*n);			//3
					
					divide(map,n,x+n,y);			//4
					divide(map,n,x+n,y+n);			//5
					divide(map,n,x+n,y+2*n);		//6
					
					divide(map,n,x+2*n,y);			//7
					divide(map,n,x+2*n,y+n);		//8
					divide(map,n,x+2*n,y+2*n);		//9

					
				}
				if(check)
					break;
			}
			if(check)
				break;
		}
		
		if(!check) {
			if(flag==-1)
				a++;
			else if(flag==0)
				b++;
			else
				c++;
		}
	}

}
