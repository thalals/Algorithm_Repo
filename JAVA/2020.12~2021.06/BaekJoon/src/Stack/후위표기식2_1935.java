/* 백준 1935번 후위표기식 2
 * (문제)
 * 후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.
 * 
 * (입력)
 * 첫째 줄에 피연산자의 개수(1 ≤ N ≤ 26) 가 주어진다. 그리고 둘째 줄에는 후위 표기식이 주어진다. 
 * (여기서 피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다) 
 * 그리고 셋째 줄부터 N+2번째 줄까지는 각 피연산자에 대응하는 값이 주어진다. 
 * (3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B에 해당하는값 ,
 * 5번째 줄에는 C ...이 주어진다, 그리고 피연산자에 대응 하는 값은 정수이다)
 */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식2_1935 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split("");
		int input_result[] = new int[input.length];
		
		for(int i =0; i<input.length;i++) {
			input_result[i] = (int)input[i].charAt(0);	//아스키 코드로 변환
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
