// ���� 17952�� �ڹ� ������ ������ �ʾ�
// �������� Ǯ����

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;
import java.util.StringTokenizer;

public class �ǹ�3_17952_�����³������ʾ� {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int minute = Integer.parseInt(br.readLine());
		
		Stack<int[]> st = new Stack<int[]>();
		
		int count = 0 ;
		int sum = 0;
		
		for(int i =0;i<minute;i++) {
			String str = br.readLine();
			StringTokenizer temp = new StringTokenizer(str);
			
			int flag = Integer.parseInt(temp.nextToken());
			
			if(flag == 1) {
				int bucket[] = new int[2];
				bucket[0] = Integer.parseInt(temp.nextToken()); //����
				bucket[1] = Integer.parseInt(temp.nextToken()) -1 ; //�ð�
				
				if(bucket[1]==0)
					sum+=bucket[0];
				else
					st.add(bucket);
			}
			
			else if(flag == 0) {
				if(!st.isEmpty()) {
					int bucket[] = new int[2];
					
					bucket = st.pop();
					bucket[1] += -1 ; //�ð�
	
					if(bucket[1]==0)
						sum+=bucket[0];
					else
						st.add(bucket);
				}
			}
			
		}
		System.out.println(sum);
		
		br.close();
	}

}
