/* 백준 1108 브1
 * 복붙의 달인
 */
package level_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 백준_11008번_브1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int i =0;i<t;i++) {
			int time =0 ;
						
			String st[] = br.readLine().split(" ");
			
			String s = st[0];
			String p = st[1];
			
			int size = s.length();
			
			boolean flag = false;
			
			for(int j=0;j<size-p.length()+1;j++) {
				if(p.length()==0)
					break;
				
				if(flag){
					j=j-1+p.length();
					flag=false;
                    if(j>size-p.length())
                        break;
                    
                }
				
                String str = s.substring(j, p.length()+j);

				if(str.equals(p)) {
					flag=true;
					time++;
				}
			}
			bw.append(size+time-(time*p.length())+"\n");
		}
		bw.flush();
		
	}

}
