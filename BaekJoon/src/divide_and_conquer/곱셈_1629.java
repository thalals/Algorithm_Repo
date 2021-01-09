/*
 * °ö¼À ½Ç¹ö 1
 * ¹éÁØ ÀÚ¹Ù 1629 ºÐÇÒÁ¤º¹
 */

package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class °ö¼À_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		
		

		System.out.println(recursive(a, b, c, 0)%c);
	}
	
	static long recursive(long a, long b, long c, long count) {
		if(b==1)
			return a;
		
		if(b%2==1) {
			
		}
		
		return 0;
		
	}

}
