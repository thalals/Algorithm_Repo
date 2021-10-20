/*
 * �����׷��ӽ� 42839 ����2
 * ����Ž��, �Ҽ� ã��
 */
package level_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ���α׷��ӽ�_42839_����2 {

	static int count =0;
	
	static boolean check[] = new boolean[8];		

	static ArrayDeque<Integer> arr = new ArrayDeque<Integer>();	// ���̰� ���� ū ������ ����
	static HashSet<Integer> set_list = new HashSet<Integer>();	// �ߺ����� ������ ��� ����� �� ����Ʈ
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String st = br.readLine();
		
		solution(st);	
		
	}
	
	public static void solution(String numbers) {
		
		String temp = numbers.substring(1,numbers.length()-1);	//����ǥ ����

		String a[] = temp.split("");

		int number[] = new int[temp.length()];
		int answer = 0;
		
		for(int i=0;i<a.length;i++) {
			number[i] = Integer.parseInt(a[i]);
		}
		
		recursive(number, 0);
		while(!arr.isEmpty()) {
			int tmp = arr.poll();
			
			int count = 1;
			while(count<tmp) {
				set_list.add(tmp/count);
				count*=10;
			}
		}
		
		Iterator<Integer> iter = set_list.iterator();	//set_list ��� ����  Iterator ��ü
		
		while(iter.hasNext()) {
			int s = iter.next();
			if(isPrimNumber(s))
				answer++;
		}
		
		System.out.println(answer);
		
		
	}
	public static boolean isPrimNumber(int x) {
		if(x==1)
			return false;
		for(int i=2;i<x;i++) {
			if(x==i)
				break;
			else if(x%i == 0)
				return false;
		}
		
		return true;
	}
	static int test_case = 0;
	public static void  recursive(int number[], int idx) {
		if(number.length == idx) {
			arr.add(test_case);
			test_case=0;
			return;
		}
		
		for(int i=0;i<number.length;i++) {
			if(check[i])
				continue;
			else {
				check[i] = true;
				test_case = (int) (test_case + number[i]*(Math.pow(10, idx)));
				recursive(number, idx+1);   
				
				check[i] = false;
				
			}
		}
	}
	
}
