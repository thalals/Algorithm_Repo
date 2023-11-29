package dfs_bfs.level3_네트워크;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}), 2);
        Assertions.assertEquals(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}), 1);
        Assertions.assertEquals(solution(3, new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}), 3);
        Assertions.assertEquals(
            solution(4, new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}), 1);
        Assertions.assertEquals(solution(1, new int[][]{{1}}), 1);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visit[i]) {
                answer++;
                networkCheck(visit, computers, i);
            }
        }

        return answer;
    }

    public void networkCheck(boolean[] visit, int[][] computers, int index) {

        visit[index] = true;

        for (int j = 0; j < visit.length; j++) {
            if (!visit[j] && computers[index][j] == 1) {
                networkCheck(visit, computers, j);
            }
        }
    }
}
