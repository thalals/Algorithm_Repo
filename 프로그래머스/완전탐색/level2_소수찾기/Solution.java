package 완전탐색.level2_소수찾기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {

    private static final Set<Integer> allNumbers = new HashSet<>();

    @Test
    public void test() {

        Assertions.assertEquals(solution("17"), 3);
        Assertions.assertEquals(solution("011"), 2);

    }

    public int solution(String numbers) {
        int answer = 0;

        Integer[] number = Arrays.stream(numbers.split("")).map(Integer::parseInt)
            .toArray(Integer[]::new);

        int output[]=new int[number.length];
        boolean visited[]=new boolean[number.length];

        for(int i=0;i<number.length;i++){
            permutation(number,output,visited,0,i+1);
        }

        for (int n : allNumbers) {
            if (isPrime(n)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void permutation(Integer arr[], int output[], boolean visited[], int depth, int r) {
        if(depth==r){
            int asInt = Arrays.stream(output).limit(r).reduce((left, right) -> left * 10 + right).getAsInt();
            allNumbers.add(asInt);
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                //첫째 0 제거
                if (depth == 0 && arr[i] == 0) {
                    continue;
                }
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr,output,visited,depth+1,r);
                visited[i]=false;
            }
        }
    }
}

