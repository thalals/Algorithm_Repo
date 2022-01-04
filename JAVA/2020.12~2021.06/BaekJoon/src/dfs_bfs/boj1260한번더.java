package dfs_bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class boj1260ÇÑ¹ø´õ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean visit[];
	
	public static void main(String[] args) throws IOException {
		
		String temp[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int v = Integer.parseInt(temp[2]);
		
		visit = new boolean[n+1];
		
		ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<n+1;i++)
			map.add(new ArrayList<Integer>());
		
		for(int i=0;i<m;i++) {
			temp = br.readLine().split(" ");
			int a[] = new int[2];
			a[0] = Integer.parseInt(temp[0]);
			a[1] = Integer.parseInt(temp[1]);
			
			map.get(a[0]).add(a[1]);
			map.get(a[1]).add(a[0]);

 		}
		
		dfs(map,v);
		bw.append("\n");
		
		Arrays.fill(visit, false);
		
		bfs(map,v);
		bw.flush();
		
		
	}
	
	static void dfs(ArrayList<ArrayList<Integer> >map, int start) throws IOException {
		if(visit[start])
			return;
		else {
			bw.append(start+" ");
			visit[start] = true;
			
			for(int a : map.get(start))
				dfs(map,a);
		}
	}
	
	static void bfs(ArrayList<ArrayList<Integer>> map, int start) throws IOException {
		if(visit[start])
			return;
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.offer(start);
		
		visit[start] = true;
		
		
			
//			for(int a : map.get(start)) {
//				if(!visit[a]) {
//					dq.offer(a);
//					visit[a] = true;
//			}
//			}
		
		
//		for(int a : map.get(start)) {
//			if(!visit[a]) {
//				dq.offer(a);
//				visit[a] = true;
//				bw.append(a+" ");
//			}
//		}
//		
//		while(!dq.isEmpty())
//			bfs(map,dq.poll());
	}
}
