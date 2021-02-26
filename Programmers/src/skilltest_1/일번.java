package skilltest_1;

import java.io.IOException;
import java.util.Scanner;

public class ÀÏ¹ø {

	public static void main(String[] args) throws IOException {
		int x;
	    Scanner sc = new Scanner(System.in);
	    
	    String temp[] = sc.next().split("");
	    
	    int a=0;
	    int b=0;
	    
	    for(int i=0;i<temp.length;i++) {
	    	if(temp[i].contains("("))
	    		a++;
	    	else
	    		b++;
	    }
	    
	    if(a==b)
	    	System.out.println("YES");
	    else
	    	System.out.println("NO");
	}
}
