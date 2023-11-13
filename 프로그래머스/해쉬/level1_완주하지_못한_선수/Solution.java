package 해쉬.level1_완주하지_못한_선수;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {
        assertAll(
            () -> assertEquals(
                solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}), "leo"),
            () -> assertEquals(
                solution(
                    new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                    new String[]{"josipa", "filipa", "marina", "nikola"}),
                "vinko"),
            () -> assertEquals(
                solution(
                    new String[]{"mislav", "stanko", "mislav", "ana"},
                    new String[]{"stanko", "ana", "mislav"}),
                "mislav")
        );
    }

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();

        for(String participator : participant){
            map.put(participator, map.getOrDefault(participator, 0) + 1);
        }

        for (String completedPerson : completion) {
            map.put(completedPerson, map.get(completedPerson) - 1);
        }

        return map.keySet().stream().filter(key -> map.get(key) > 0).findFirst().get();
    }


}
