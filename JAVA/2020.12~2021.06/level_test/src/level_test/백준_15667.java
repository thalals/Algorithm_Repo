/* �����3
 * 2018 �������б� ���α׷��� ������ȸ
 */
package level_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ����_15667 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int tmp = n-1;
		int result = -1;
		
		for(int i = 1; i<15200;i++) {
			if(i*(i+1)==tmp) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
