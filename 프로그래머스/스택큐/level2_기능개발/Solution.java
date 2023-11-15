package 스택큐.level2_기능개발;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        assertAll(
            () -> assertEquals(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}), new int[]{2, 1}),
            () -> assertEquals(solution(new int[]{495, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}), new int[]{1, 3, 2})
        );
    }

    public Integer[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(getCompleteDay(progresses[i], speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();

        while (!queue.isEmpty()) {
            int count = 1;

            int first = queue.poll();

            while (queue.peek() != null && first >= queue.peek()) {
                count++;
                queue.poll();
            }
            answer.add(count);
        }

        return answer.toArray(new Integer[0]);
    }

    private int getCompleteDay(int progress, int speed) {

        int remain = 100 - progress;

        if (remain % speed == 0) {
            return remain / speed;
        }

        return remain / speed + 1;
    }
}