package 힙.level2_더맵게;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {

        assertAll(
            () -> assertEquals(solution(new int[]{10, 10, 10, 10, 10}, 100), 4),
            () -> assertEquals(solution(new int[]{1, 2, 3, 9, 10, 12}, 7), 2),
            () -> assertEquals(solution(new int[]{1, 2}, 7), -1),
            () -> assertEquals(solution(new int[]{8}, 7), 0),
            () -> assertEquals(solution(new int[]{1, 1, 1, 1}, 1), 0),
            () -> assertEquals(solution(new int[]{1, 1, 1, 1}, 7), 3),
            () -> assertEquals(solution(new int[]{1, 1, 2, 6}, 30), -1),
            () -> assertEquals(solution(new int[]{1, 1, 2, 6}, 1), 0),
            () -> assertEquals(solution(new int[]{1, 1, 2, 6}, 2), 1),
            () -> assertEquals(solution(new int[]{1, 1, 2, 6}, 6), 2),
            () -> assertEquals(solution(new int[]{1, 1, 2, 6}, 8), 3),
            () -> assertEquals(solution(new int[]{1, 1, 1}, 4), 2),
            () -> assertEquals(solution(new int[]{0, 2, 3, 9, 10, 12}, 7), 2),
            () -> assertEquals(solution(new int[]{0, 0, 3, 9, 10, 12}, 0), 0),
            () -> assertEquals(solution(new int[]{0, 0, 3, 9, 10, 12}, 1), 2),
            () -> assertEquals(solution(new int[]{0, 0}, 0), 0),
            () -> assertEquals(solution(new int[]{0, 0}, 1), -1),
            () -> assertEquals(solution(new int[]{1, 0}, 1), 1),
            () -> assertEquals(solution(new int[]{0, 0, 3, 9, 10, 12}, 7), 3),
            () -> assertEquals(solution(new int[]{0, 0, 3, 9, 10, 12}, 7000), -1),
            () -> assertEquals(solution(new int[]{0, 0, 0, 0}, 7), -1)
        );
    }

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int a : scoville) {
            priorityQueue.add(a);
        }

        int answer = 0;

        while (!priorityQueue.isEmpty()) {

            if (priorityQueue.peek() >= K) {
                return answer;
            }

            if (priorityQueue.size() < 2) {
                return -1;
            }

            int mix = priorityQueue.poll() + priorityQueue.poll() * 2;
            priorityQueue.add(mix);
            answer++;
        }

        return -1;

    }

}
