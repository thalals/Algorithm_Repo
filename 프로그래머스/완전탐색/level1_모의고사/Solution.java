package 완전탐색.level1_모의고사;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    private static final int[] number1 = {1, 2, 3, 4, 5};
    private static final int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    @Test
    public void test() {

        Assertions.assertAll(
            () -> assertEquals(solution(new int[]{1, 2, 3, 4, 5}), new int[]{1}),
            () -> assertEquals(solution(new int[]{1, 3, 2, 4, 2}), new int[]{1, 2, 3})
        );

    }

    public List<Integer> solution(int[] answers) {

        List<Integer> result = new ArrayList<>();

        int a1 = getCount(answers, number1);
        int a2 = getCount(answers, number2);
        int a3 = getCount(answers, number3);

        int max = Math.max(Math.max(a1, a2), a3);
        if (a1 == max) {
            result.add(1);
        }

        if (a2 == max) {
            result.add(2);
        }

        if (a3 == max) {
            result.add(3);
        }

        return result;
    }

    private static int getCount(int[] answers, int[] personWhoGaveUp) {

        int count = 0;
        int size = personWhoGaveUp.length;

        for (int i = 0; i < answers.length; i++) {

            if (answers[i] == personWhoGaveUp[i % size]) {
                count++;
            }
        }

        return count;
    }


}