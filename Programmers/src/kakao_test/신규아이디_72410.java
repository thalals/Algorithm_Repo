package kakao_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class 신규아이디_72410 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String new_id = br.readLine();

		
		System.out.println(solution(new_id));

	}

	public static String a(String new_id) {
		return new_id.toLowerCase();
	}

	public static String b(String new_id) {
		String str[] = new_id.split("");

		for (int i = 0; i < str.length; i++) {
			int key = str[i].charAt(0);

			if (key >= 48 && key <= 57)
				continue;
			else if (key == 45 || key == 46 || key == 95)
				continue;
			else if (key >= 97 && key <= 122)
				continue;
			else
				str[i] = null;
		}

		StringBuilder at = new StringBuilder();

		for (String a : str) {
			if (a == null)
				continue;
			at.append(a);
		}

		return at.toString();

	}

	public static String c(String new_id) {
		String str[] = new_id.split("");
		
		StringBuilder at = new StringBuilder();
		at.append(new_id.charAt(0));
		for (int i = 1; i < str.length; i++) {
			if(at.charAt(at.length()-1)==46 && str[i].charAt(0)==46)
				continue;
			else
				at.append(str[i]);
		}
		

		return at.toString();

	}

	public static String remove(String new_id) {
		
		if(!new_id.isEmpty())
			if(new_id.charAt(0)==46)
				new_id = new_id.substring(1, new_id.length());
		if(!new_id.isEmpty())
			if(new_id.charAt(new_id.length()-1)==46)
				new_id = new_id.substring(0,new_id.length()-1);

		return new_id;
	}

	public static String solution(String new_id) {
        String answer = "";
        
		new_id = a(new_id);
		System.out.println("1 : "+new_id);
		new_id = b(new_id);
		System.out.println("2 : "+new_id);

		new_id = c(new_id);
		System.out.println("3 : "+new_id);

		new_id = remove(new_id);
		System.out.println("4 : "+new_id);

		//5
		if(new_id.length()==0) {
			new_id = "a";
		}
			
		System.out.println("5 : "+new_id);

		//6
		if(new_id.length()>=15) {
			new_id = new_id.substring(0, 15);
		}
		System.out.println("6 : "+new_id);

		
		new_id = remove(new_id);

		//7
		StringBuilder at = new StringBuilder();

		if(new_id.length()<3) {
			at.append(new_id);
			while(at.length()!=3)
				at.append(new_id.charAt(new_id.length()-1));
		}
		else {
			at.append(new_id);
		}

		answer = at.toString();
		System.out.println("7 : "+answer);

		return answer;
	}

}
