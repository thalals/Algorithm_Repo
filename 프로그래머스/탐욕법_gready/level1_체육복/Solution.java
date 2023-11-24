package 탐욕법_gready.level1_체육복;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {

        Assertions.assertAll(
            () -> Assertions.assertEquals(solution(5, new int[]{4, 2}, new int[]{5, 3, 1}), 5),
            () -> Assertions.assertEquals(solution(5, new int[]{2, 4}, new int[]{3}), 4),
            () -> Assertions.assertEquals(solution(3, new int[]{3}, new int[]{1}), 2),
            () -> Assertions.assertEquals(solution(5, new int[]{5, 3}, new int[]{4, 2}), 5),
            () -> Assertions.assertEquals(solution(5, new int[]{2, 4}, new int[]{1, 3}), 5)
        );
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] person = new int[n];

        for (int index : lost) {
            person[index - 1] -= 1;
        }

        for (int index : reserve) {
            person[index - 1] += 1;
        }

        for (int i = 0; i < n; i++) {
            if(person[i] < 0){
                if (i-1 >= 0 && person[i-1] > 0) {
                    person[i - 1] -= 1;
                    person[i] += 1;
                    continue;
                }

                if (i + 1 < n && person[i + 1] > 0) {
                    person[i + 1] -= 1;
                    person[i] += 1;
                }
            }
        }

        return (int) Arrays.stream(person).filter(value -> value >= 0).count();
    }
}
