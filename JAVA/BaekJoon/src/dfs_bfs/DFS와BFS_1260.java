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
import java.util.LinkedList;
import java.util.TreeSet;

public class DFS와BFS_1260 {

	static boolean visit[];
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static ArrayList<TreeSet<Integer>> map = new ArrayList<TreeSet<Integer>>();

	public static void main(String[] args) throws IOException {

		String tmp[] = br.readLine().split(" ");
		int point = Integer.parseInt(tmp[0]);
		int line = Integer.parseInt(tmp[1]);
		int start = Integer.parseInt(tmp[2]);
//		int map[][] = new int[point+1][point+1];

		visit = new boolean[point + 1];

		for (int i = 0; i < point + 1; i++) {
			map.add(new TreeSet<Integer>());
		}
		for (int i = 0; i < line; i++) {
			String t[] = br.readLine().split(" ");

			map.get(Integer.parseInt(t[0])).add(Integer.parseInt(t[1]));
			map.get(Integer.parseInt(t[1])).add(Integer.parseInt(t[0]));

//			map[Integer.parseInt(t[0])][Integer.parseInt(t[1])] = 1;
//			map[Integer.parseInt(t[1])][Integer.parseInt(t[0])] = 1;

		}

//		DFS(map,start);
		ListDfs(start);

		Arrays.fill(visit, false); // boolean 배열 초기화

		bw.append("\n");
		BFS(start);

		bw.flush();

		bw.close();
		br.close();

	}

	public static void BFS(int start) throws IOException {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		dq.offer(start);
		visit[start] = true;
		
		while(!dq.isEmpty()) {
			int tmp = dq.poll();	//방문위치
			
			bw.append(tmp+" ");
			
			for(int a : map.get(tmp)) {
				if(!visit[a]) {
					dq.offer(a);
					visit[a] = true;
				}
			}
		}

	}

	// 인접리스트
	public static void ListDfs(int start) throws IOException {
		if (visit[start])
			return;

		bw.append(start + " ");
		visit[start] = true;

		for (int a : map.get(start)) {
			ListDfs(a);
		}

	}

	// 형렬로
	public static void DFS(int[][] map, int start) throws IOException {
		if (visit[start]) {
			return;
		}
		bw.append(start + " ");
		visit[start] = true;

		for (int i = 0; i < map[0].length; i++) {
			if (map[start][i] == 1) {
				DFS(map, i);
			}
		}

	}
}
