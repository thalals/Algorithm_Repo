package dfs_bfs.level3_단어변환;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}), 4);
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        Queue<Word> bfsList = new LinkedList<>();
        bfsList.add(new Word(0, new boolean[words.length], begin));

        while (!bfsList.isEmpty()) {
            Word word = bfsList.poll();

            if (word.now.equals(target)) {
                return word.count;
            }

            //bfs
            //변환 가능한지 - 1개의 알파벳만 바꿀 수 있음
            //내가 방문 했는지 - 방문했던건 다시 방문 할 필요가 없다
            for (int i = 0; i < words.length; i++) {
                if (!word.visited[i] && word.isChange(words[i])) {
                    boolean[] visited = word.visited;
                    visited[i] = true;
                    bfsList.add(new Word(word.count + 1, visited, words[i]));
                }
            }
        }

        return answer;
    }
}

class Word{

    int count;
    boolean[] visited;
    String now;

    public Word(int count, boolean[] visited, String now) {
        this.count = count;
        this.visited = visited;
        this.now = now;
    }

    public boolean isChange(String word) {

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != now.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
