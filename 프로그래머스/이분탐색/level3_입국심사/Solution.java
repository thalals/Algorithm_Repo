package 이분탐색.level3_입국심사;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test (){
        Assertions.assertEquals(solution(6, new int[]{7, 10}), 28);
        Assertions.assertEquals(solution(6, new int[]{1, 10}), 6);
        Assertions.assertEquals(solution(6, new int[]{4, 10}), 20);
        Assertions.assertEquals(solution(59, new int[]{1, 1}), 30);
        Assertions.assertEquals(solution(5, new int[]{1, 1, 10}), 3);
        Assertions.assertEquals(solution(11, new int[]{3, 4, 10}), 18);
     }

    public long solution(int n, int[] times) {
        long minTime = 0;
        long maxTime = (long)Arrays.stream(times).max().getAsInt() *(long) n;

        //작업완료까지 남은시간
        while (minTime < maxTime) {

            int sum = 0;
            long mid = (minTime + maxTime) / 2;

            for (int time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                maxTime = mid;
                continue;
            }

            if (sum < n) {
                minTime = mid + 1;
            }

        }

        return minTime;
    }

}
