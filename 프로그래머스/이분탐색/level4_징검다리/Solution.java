package 이분탐색.level4_징검다리;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(solution(25, new int[]{2, 14, 11, 21, 17}, 2), 4);
        Assertions.assertEquals(solution(1, new int[]{1}, 1), 1);
        Assertions.assertEquals(solution(48, new int[]{12, 25, 38, 43}, 1), 10);
    }

    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        int min = 0;
        int max = distance;

        if (n == rocks.length) {
            return distance;
        }

        while (min < max) {
            int mid = (min + max) / 2;

            int reduceRockCount = 0;
            int start = 0;

            for (int rock : rocks) {
                if (rock - start < mid) {
                    reduceRockCount++;
                }
                else {
                    start = rock;
                }
            }

            //마지막 돌체
            if (distance - start < mid) {
                reduceRockCount++;
            }

            if (reduceRockCount > n) {
                max = mid ;
            }
            else {
                min = mid + 1;
            }
        }

        return min-1;
    }
}
