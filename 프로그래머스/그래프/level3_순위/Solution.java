package 그래프.level3_순위;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}), 2);
        Assertions.assertEquals(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}, {1, 4}}), 5);
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        Map<Integer, Map<String, Set<Integer>>> player = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            player.put(i, new HashMap<>());
            player.get(i).put("win", new HashSet<>());
            player.get(i).put("lose", new HashSet<>());
        }

        for (int[] result : results) {

            int winner = result[0];
            int loser = result[1];

            player.get(winner).get("win").add(loser);
            player.get(loser).get("lose").add(winner);
        }

        //플로이드 와샬
        for (int i = 1; i <= n; i++) {

            winnerFloyd(player, i, player.get(i).get("win"), new boolean[n+1]);
            loserFloyd(player, i, player.get(i).get("lose"), new boolean[n+1]);
        }

        //result
        for (int i = 1; i <= n; i++) {
            if(player.get(i).get("win").size() + player.get(i).get("lose").size() == n-1)
                answer++;
        }

        return answer;
    }

    public void winnerFloyd(Map<Integer, Map<String, Set<Integer>>> player, int playerNumber, Set<Integer> targetPlayer, boolean[] visited) {

        player.get(playerNumber).get("win").addAll(targetPlayer);

        for(int win : targetPlayer.stream().collect(Collectors.toList())){
            if(!visited[win]) {
                visited[win] = true;
                winnerFloyd(player, playerNumber, player.get(win).get("win"), visited);
            };
        }
    }

    public void loserFloyd(Map<Integer, Map<String, Set<Integer>>> player, int playerNumber, Set<Integer> targetPlayer, boolean[] visited) {

        player.get(playerNumber).get("lose").addAll(targetPlayer);

        for(int lose : targetPlayer.stream().collect(Collectors.toList())){
            if(!visited[lose]) {
                visited[lose] = true;
                loserFloyd(player, playerNumber, player.get(lose).get("lose"), visited);
            };
        }
    }
}
