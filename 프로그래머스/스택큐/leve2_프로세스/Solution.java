package 스택큐.leve2_프로세스;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {
        Assertions.assertAll(
            () -> Assertions.assertEquals(solution(new int[]{1, 1, 9, 1, 1, 1}, 0), 5),
            () -> Assertions.assertEquals(solution(new int[]{2, 1, 3, 2}, 2), 1)
        );

    }

    public int solution(int[] priorities, int location) {

        PriorityQueue<Integer> priorityHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Process> processQueue = new LinkedList<>();

        for (int i=0; i<priorities.length; i++) {
            priorityHeap.add(priorities[i]);
            processQueue.add(new Process(i, priorities[i]));
        }

        int answer = 1;

        while (priorityHeap.peek() != processQueue.peek().priority || processQueue.peek().location != location) {

            Integer priority = priorityHeap.poll();

            while (processQueue.peek().priority != priority) {
                processQueue.add(processQueue.poll());
            }

            Process process = processQueue.poll();

            if (process.location == location) {
                return answer;
            }
            answer++;
        }

        return answer;
    }
}

class Process {

    int location;
    int priority;

    public Process(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}
