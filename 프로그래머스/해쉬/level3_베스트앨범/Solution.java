package 해쉬.level3_베스트앨범;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}), new int[]{4, 1, 3, 0});
    }

    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, List<Music>> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            List<Music> orDefault = map.getOrDefault(genres[i], new LinkedList<>());
            orDefault.add(new Music(i, plays[i]));
            map.put(genres[i], orDefault);
        }

        TreeSet<GenreInfo> set = new TreeSet<>();
        for (String key : map.keySet()) {
            set.add(new GenreInfo(key, map.get(key)));
        }

        Iterator<GenreInfo> iterator = set.iterator();
        while (iterator.hasNext()) {
            for (int index : iterator.next().getBest()) {
                answer.add(index);
            }
        }

        return answer;
    }
}

class GenreInfo implements Comparable<GenreInfo> {

    String name;
    int total;
    List<Music> list;

    public GenreInfo(String name, List<Music> list) {
        this.name = name;
        this.total = list.stream().map(Music::getPlay).reduce(Integer::sum).orElse(0);
        this.list = list;
    }

    @Override
    public int compareTo(GenreInfo o) {
        return o.total - this.total;
    }

    public List<Integer> getBest() {
        return list.stream().sorted(Comparator.comparing(Music::getPlay).reversed())
            .limit(2)
            .map(Music::getIndex)
            .collect(Collectors.toList());
    }
}

class Music {

    int index;
    int play;

    public Music(int index, int play) {
        this.index = index;
        this.play = play;
    }

    public int getPlay() {
        return play;
    }

    public int getIndex() {
        return index;
    }
}
