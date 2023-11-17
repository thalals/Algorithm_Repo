package 정렬.level1_k번째수;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(
            solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}),
            new int[]{5, 6, 3});
    }

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int index = 0;

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] subArray = Arrays.copyOfRange(array, i-1, j);

            int[] result = Arrays.stream(subArray).sorted().toArray();
            answer[index++] = result[k - 1];
        }

        return answer;
    }
}
