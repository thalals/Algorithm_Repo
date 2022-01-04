/*
 * ���� ť ������ť, 1966��
 */
package Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class ������ť_1966 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int test = Integer.parseInt(br.readLine());
		String str;
		
		for(int i=0;i<test;i++) {
			Deque<int[]> dq = new ArrayDeque<int[]>();

			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int n = Integer.parseInt(st.nextToken());	//���� ����
			int m = Integer.parseInt(st.nextToken());	//�ñ��� ���� 

			String importance[] = br.readLine().split(" ");	//�߿䵵
			
			int point[] = {Integer.parseInt(importance[m]),m};	//�߿䵵, �ε���
			int count = 0;
			
			for(int k =0;k<n;k++){
				dq.offer(new int[]{Integer.parseInt(importance[k]),k});
			}
			
			while(!dq.isEmpty()) {
				int tmp[] = dq.poll();
				boolean plag = false;
				
				
				for(int[] a : dq) {
					if(tmp[0]<a[0]) {
						dq.offer(tmp);		//�ٽ� �ڷ� ����
						plag = true;
						break;
					}
				}
				
				if(plag) 
					continue;
				
				count++;

				
				if(tmp[0]==point[0]&&tmp[1]==point[1]) {
					bw.append(count+"\n");
					break;
				}
				
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

