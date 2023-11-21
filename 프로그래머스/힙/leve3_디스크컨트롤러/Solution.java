package 힙.leve3_디스크컨트롤러;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {

        assertAll(
            () -> assertEquals(solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}), 9)
//            () -> assertEquals(solution(new int[][]{{0, 3}, {1, 9}, {1, 4}, {2, 6}}), 11)
        );

//        (0)3 + (3)6 + (7)15 + (16)20
    }

    public int solution(int[][] jobs) {

        int totalTime = 0;
        int size = jobs.length;
        int now = 0;

        PriorityQueue<Job> priorityQueue = new PriorityQueue<>();
        for (int[] job : jobs) {
            priorityQueue.add(new Job(job[0], job[1]));
        }

        while (!priorityQueue.isEmpty()) {
            Job job = priorityQueue.poll();
            List<Job> jobList = new ArrayList<>();

            while (!priorityQueue.isEmpty() && priorityQueue.peek().request <= now) {
                Job poll = priorityQueue.poll();
                if (poll.time < job.time) {
                    jobList.add(job);
                    job = poll;
                }
                else jobList.add(poll);
            }

            priorityQueue.addAll(jobList);

            totalTime += Math.max(now - job.request, 0) + job.time;
            now += Math.max(job.request - now, 0) + job.time;
        }


        return totalTime / size;
    }

}

class Job implements Comparable<Job> {
    int request;
    int time;

    public Job(int request, int time) {
        this.request = request;
        this.time = time;
    }


    @Override
    public int compareTo(Job o) {
        if (o.request == this.request) {
            return this.time < o.time ? -1 : 1;
        }

        return this.request < o.request ? -1 : 1 ;
    }
}
