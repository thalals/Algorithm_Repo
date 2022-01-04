/* ���� 18258�� ť2
 * 
 * ������ �����ϴ� ť�� ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� ���� �����̴�.

push X: ���� X�� ť�� �ִ� �����̴�.
pop: ť���� ���� �տ� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ť�� ����ִ� ������ ������ ����Ѵ�.
empty: ť�� ��������� 1, �ƴϸ� 0�� ����Ѵ�.
front: ť�� ���� �տ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
back: ť�� ���� �ڿ� �ִ� ������ ����Ѵ�. ���� ť�� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.

(�Է�)
ù° �ٿ� �־����� ����� �� N (1 �� N �� 2,000,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����.
 �־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.
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

public class ť2_18258 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	//��� ��ü (�迭���� �ð� �ʰ�)
		
		int n = Integer.parseInt(br.readLine());	// ��ɾ� ����
		
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