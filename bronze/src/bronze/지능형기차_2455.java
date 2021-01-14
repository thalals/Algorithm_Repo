package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class 지능형기차_2455 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		
//		Iterator<Integer> iter = result.iterator();
		int [] result = new int[4];
		
		for(int i=0;i<4;i++) {
			String tmp[] = br.readLine().split(" ");
			int out = Integer.parseInt(tmp[0]);
			int in = Integer.parseInt(tmp[1]);
			
			if(i==0) {
				result[i] =(in-out);
			}
			else {				
				int t = result[i-1]+in-out;
				result[i]=t;
			}

		}
		
		int max = -1;
		for(int a : result) {
			if(a>max)
				max = a;
		}
		System.out.println(max);
	}

}
