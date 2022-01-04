package kakao_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 성민 {
	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			String s = input.readLine();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
					s = s.replace(s.charAt(i), (char) (s.charAt(i) + 32));
			}
			System.out.println(s);
			for (int i = 0; i < s.length(); i++) {// 문자 제거
				if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')
						|| s.charAt(i) == '-' || s.charAt(i) == '_' || s.charAt(i) == '.')
					continue;
				else {
					s = s.replace(String.valueOf(s.charAt(i)), "");
					i--;
				}
			}
			System.out.println(s);
			StringBuffer temps = new StringBuffer(s);
			for (int i = 0; i < temps.length(); i++) {// 마침표 치환
				if (i == 0)
					continue;
				if (temps.length() >= 2 && temps.charAt(temps.length() - 1) == '.')
					temps.deleteCharAt(temps.length() - 1);
			}
			System.out.println(temps);
			if (temps.charAt(0) == '.')
				temps.deleteCharAt(0);
			if (temps.charAt(temps.length() - 1) == '.')
				temps.deleteCharAt(temps.length() - 1);
			System.out.println(temps);
			if (temps.length() == 0)
				temps.append("a");
			System.out.println(temps);
			if (temps.length() >= 16) {
				while (temps.length() != 15)
					temps.deleteCharAt(temps.length() - 1);
				if (s.charAt(temps.length() - 1) == '.')
					temps.deleteCharAt(temps.length() - 1);
			}
			System.out.println(temps);
			if (temps.length() <= 2)
				while (temps.length() != 3)
					temps.append(temps.charAt(temps.length() - 1));
			System.out.println(temps.substring(0));
			input.close();
			String an = temps.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}