package 그래프.level3_가장먼노드;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}),3);
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxDistance = 0;
        boolean[] visited = new boolean[n+1];

        Map<Integer, Map<Integer, Integer>> enableMoveMap = new HashMap<>();
        while (n > 0) {
            enableMoveMap.put(n--, new HashMap<>());
        }

        for(int[] line : edge){

            int aNode = line[0];
            int bNode = line[1];

            enableMoveMap.get(aNode).put(bNode, 0);
            enableMoveMap.get(bNode).put(aNode, 0);
        }

        //find start 1 node
        Queue<Tuple> bfs = new LinkedList<>();

        for(int node : enableMoveMap.get(1).keySet().stream().collect(Collectors.toList())){
            bfs.add(new Tuple(node, 1));
        }

        visited[1] = true;

        while (!bfs.isEmpty()) {
            Tuple poll = bfs.poll();
            if (!visited[poll.getNode()]) {
                visited[poll.getNode()] = true;

                if (maxDistance == poll.distance) {
                    answer++;
                } else if (maxDistance < poll.distance) {
                    answer = 1;
                    maxDistance = poll.distance;
                }

                for(int node : enableMoveMap.get(poll.node).keySet().stream().collect(Collectors.toList())){
                    bfs.add(new Tuple(node, poll.distance+1));
                }
            }
        }


        return answer;
    }
}

class Tuple {
    int node;
    int distance;

    public Tuple(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int getNode() {
        return node;
    }
}
