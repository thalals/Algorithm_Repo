package 완전탐색.level2_전력망둘로나누기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}), 3);
        Assertions.assertEquals(solution(3, new int[][]{{1, 2}, {2, 3}}), 1);
    }


    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        Map < Integer, List<Integer>> wireMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            wireMap.put(i, new ArrayList<>());
        }

        for (int[] wire : wires) {
            wireMap.getOrDefault(wire[0], new LinkedList<>()).add(wire[1]);
            wireMap.getOrDefault(wire[1], new LinkedList<>()).add(wire[0]);
        }

        for (int[] wire : wires) {

            //해당 연결을 끊었을 때 각 네트워크 수의 차이 절대 값
            int absCountCuttingNetwork =  Math.abs(countNetwork(wireMap, wire[0], wire[1]) - countNetwork(wireMap, wire[1], wire[0]));

            answer = Math.min(answer, absCountCuttingNetwork);
        }

        return answer;
    }

    private int countNetwork(Map<Integer, List<Integer>> wires, int start, int cut) {

        boolean[] visited = new boolean[wires.size()];
        visited[cut] = true;

        Queue<Integer> bfs = new LinkedList<>();

        for (int network : wires.get(start)) {
            if (network != cut) {
                bfs.add(network);
            }
        }

        if (bfs.isEmpty()) {
            return 1;
        }

        int count = 0;

        while (!bfs.isEmpty()) {
            Integer poll = bfs.poll();
            if (!visited[poll]) {
                visited[poll] = true;
                count++;
                bfs.addAll(wires.get(poll));
            }
        }

        return count;

    }
}
