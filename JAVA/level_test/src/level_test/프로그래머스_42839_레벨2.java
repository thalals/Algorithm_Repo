/*
 * 프래그래머스 42839 레벨2
 * 완전탐색, 소수 찾기
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

public class 프로그래머스_42839_레벨2 {

	static int count =0;
	
	static boolean check[] = new boolean[8];		

	static ArrayDeque<Integer> arr = new ArrayDeque<Integer>();	// 길이가 가장 큰 수들의 모음
	static HashSet<Integer> set_list = new HashSet<Integer>();	// 중복값을 제외한 모든 경우의 수 리스트
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String st = br.readLine();
		
		solution(st);	
		
	}
	
	public static void solution(String numbers) {
		
		String temp = numbers.substring(1,numbers.length()-1);	//따옴표 제거

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
		
		Iterator<Integer> iter = set_list.iterator();	//set_list 출력 위한  Iterator 객체
		
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
