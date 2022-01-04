//�ǹ�4 ���� 10773�� �ڹ� ����
//���ù���, deque ������ Ǯ�(���� �������� ���)

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class �ǹ�4_10773_���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<Integer>();
		
		for(int i = 0;i<count;i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(number==0) {
				if(!dq.isEmpty())
					dq.pop();
			}
			else
				dq.push(number);
			
			
		}
		int sum =0;

		while(!dq.isEmpty())
			sum+=dq.pop();
		
		System.out.println(sum);
		
		br.close();
	}

}
