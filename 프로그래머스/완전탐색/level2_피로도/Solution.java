package 완전탐색.level2_피로도;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}), 3);
        Assertions.assertEquals(solution(80, new int[][]{{80, 80}, {50, 40}, {30, 10}}), 2);
    }

    private static int answer = 0;

    public int solution(int k, int[][] dungeons) {

        adventure(k, dungeons, new boolean[dungeons.length], 0, 0);

        return answer;
    }

    private void adventure(int k, int [][] dungeons, boolean[] visited, int depth, int count) {

        if (k <= 0 || depth == visited.length) {
            answer = Math.max(answer, count);
            return;
        }

        for (int i = 0; i < visited.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                adventure(k - dungeons[i][1], dungeons, visited, depth+1, dungeons[i][0] <= k ? count+1 : count);
                visited[i] = false;
            }
        }
    }
}
