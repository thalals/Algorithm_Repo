package dfs_bfs.level2_게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    private static final int[] HORIZON = new int[]{1, 0, -1, 0};
    private static final int[] VERTICAL = new int[]{0, 1, 0, -1};

    @Test
    public void test() {
        Assertions.assertEquals(solution(
            new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}}), 11);
        Assertions.assertEquals(solution(
            new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}}), -1);
    }

    public int solution(int[][] maps) {

        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        queue.add(new Node(0, 0, 1));

        return bfs(maps, visited, queue);
    }

    public int bfs(int[][] maps, boolean[][] visited, Queue<Node> queue) {

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.x == maps.length - 1 && now.y == maps[0].length - 1) {
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = now.x + VERTICAL[i];
                int moveY = now.y + HORIZON[i];

                if (moveX >= 0 && moveY >= 0 && moveX < maps.length && moveY < maps[0].length
                    && maps[moveX][moveY] == 1 && !visited[moveX][moveY]) {
                    visited[moveX][moveY] = true;
                    queue.add(new Node(moveX, moveY, now.count+1));
                }
            }
        }

        return -1;
    }
}

class Node {

    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
