/* 
 * 백준 AC, 큐 5430번
 * 언어 AC, 함수 뒤집기와 버리기
 * 
 * 런타임 에러 왜 나는건지 이해 무
 */
package Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_num = Integer.parseInt(br.readLine());
		
		for(int i =0;i<test_num;i++) {
			String f = br.readLine();
			String function[] = f.split("");
			int size = Integer.parseInt(br.readLine());
			
			if(size==0) {
				if(f.contains("D"))
					bw.append("error\n");
				else	
					bw.append("[]");
				continue;
			}
			
			String input = br.readLine();
			input = input.substring(1,size*2);
			
			Deque<Integer> dq = new ArrayDeque<Integer>();
			
			String bucket[] = input.split(",");
			
			
			for(int j=0;j<size;j++)
				dq.offer(Integer.parseInt(bucket[j]));
			
			
			//함수 연산
			boolean flag = false;
			
			for(int j =0;j<function.length;j++) {
				
				if(flag)
					break;
				
				switch (function[j]) {
				
				case "R":
					int temp[] = new int[dq.size()];
					for(int k=0;k<temp.length;k++)
						temp[k] = dq.poll();
					for(int k=0;k<temp.length;k++)
						dq.offerFirst(temp[k]);
					
					break;
				
				case "D":
					if(dq.isEmpty()) {
						flag = true;
						bw.append("error\n");
						break;
					}
					
					dq.poll();
					break;
				
				}
			}
			
			if(!dq.isEmpty()) {
				bw.append("["+dq.poll());
				while(!dq.isEmpty()) {
					bw.append(","+dq.poll());
				}
				bw.append("]\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}
}
