/* ���� 1935�� ����ǥ��� 2
 * (����)
 * ���� ǥ��İ� �� �ǿ����ڿ� �����ϴ� ������ �־��� ���� ��, �� ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * (�Է�)
 * ù° �ٿ� �ǿ������� ����(1 �� N �� 26) �� �־�����. �׸��� ��° �ٿ��� ���� ǥ����� �־�����. 
 * (���⼭ �ǿ����ڴ� A~Z�� ���빮���̸�, A���� ������� N���� ���빮�ڸ��� ���Ǹ�, ���̴� 100�� ���� �ʴ´�) 
 * �׸��� ��° �ٺ��� N+2��° �ٱ����� �� �ǿ����ڿ� �����ϴ� ���� �־�����. 
 * (3��° �ٿ��� A�� �ش��ϴ� ��, 4��° �ٿ��� B�� �ش��ϴ°� ,
 * 5��° �ٿ��� C ...�� �־�����, �׸��� �ǿ����ڿ� ���� �ϴ� ���� �����̴�)
 */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ����ǥ���2_1935 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split("");
		int input_result[] = new int[input.length];
		
		for(int i =0; i<input.length;i++) {
			input_result[i] = (int)input[i].charAt(0);	//�ƽ�Ű �ڵ�� ��ȯ
		}
		
		double number[] = new double[n];
		for(int i =0; i<n;i++) {
			double s = Double.parseDouble(br.readLine());
			number[i] = s;
		}
		
		
		Stack<Double> st = new Stack<Double>();
		
		for(int i=0; i < input_result.length;i++) {
			if(input_result[i]>=65&&input_result[i]<=90) {
				st.push(number[input_result[i]-65]);
			}
			else {
				double num1 = st.pop();
				double num2 = st.pop();
				double result_tmp =0 ;
				
				switch(input_result[i]) {
				
				case 42 :
					result_tmp = num2*num1;
					break;
					
				case 43 :
					result_tmp = num2+num1;
					break;

				case 47:
					result_tmp = num2/num1;
					break;
					
				case 45:
					result_tmp = num2-num1;
					break;
				}
				
				st.push(result_tmp);
				
			}	
		}
		
		System.out.printf("%.2f",st.pop() );
	}

}
