/* 백준 18258번 큐2
 * 
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

(입력)
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
 */
package Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 큐2_18258 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	//출력 객체 (배열쓰면 시간 초과)
		
		int n = Integer.parseInt(br.readLine());	// 명령어 개수
		
		Queue<Integer> q = new LinkedList<Integer>();
				
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		
		int back_num = -1;
		
		for(int i =0;i<n;i++) {
			String str = br.readLine();
			StringTokenizer a = new StringTokenizer(str);
			
			String command = a.nextToken();
			switch (command) {
			case "push":
				command = a.nextToken();
				q.offer(Integer.parseInt(command));
				back_num = Integer.parseInt(command);
				break;
			
			case "pop":
				if(q.size()==0) {
					bw.write(-1+"\n");
					break;
				}				
				int re = q.poll();
				
				bw.write(re+"\n");

				
				break;
				
			case "size":
				bw.write(q.size()+"\n");

				break;
				
			case "empty":
				if(q.size()==0) {
					bw.write(1+"\n");
					break;
				}
				else {
					bw.write(0+"\n");

					break;					
				}
				
			case "back":
				if(q.size()==0) {
					bw.write(-1+"\n");

					break;
				}
				bw.write(back_num+"\n");

				break;
				
			case "front":				
				if(q.size()==0) {
					bw.write(-1+"\n");

					break;
				}
				
				int re1 = q.peek();
				bw.write(re1+"\n");

				break;
			}
		}

		 bw.flush();
		 bw.close();
		 br.close();
		 
//		for(int i : result)
//			System.out.println(i);
	}
}