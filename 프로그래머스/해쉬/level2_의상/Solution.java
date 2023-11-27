package 해쉬.level2_의상;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {

        Assertions.assertAll(
            () -> Assertions.assertEquals(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}}), 5)
        );

    }

    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) +1);
        }

        //(answer+n) + (n+ answer*n)
        for (int count : map.values()) {
            answer += answer * count + count;
        }

        return answer;
    }
}
