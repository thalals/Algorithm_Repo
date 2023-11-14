package 스택큐.level1_같은숫자는싫어;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;


public class Solution {

    @Test
    public void test() {
        assertAll(
            () -> assertEquals(solution(new int[]{1, 1, 3, 3, 0, 1, 1}), new int[]{1, 3, 0, 1}),
            () -> assertEquals(solution(new int[]{4, 4, 4, 3, 3}), new int[]{4, 3})
        );
    }


    public int[] solution(int []arr) {

        Deque<Integer> deque = new LinkedList<>();

        for (int number : arr) {
            if (deque.isEmpty()) {
                deque.add(number);
            }

            if (!deque.peekLast().equals(number)) {
                deque.add(number);
            }
        }

        int[] result = new int[deque.size()];

        int i = 0;
        while (!deque.isEmpty()) {
            result[i++] = deque.poll();
        }

        return result;
    }
}