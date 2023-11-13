package 해쉬.level1_포켓몬;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {
        Assertions.assertAll(
            () -> Assertions.assertEquals(solution(new int[]{3, 1, 2, 3}),2),
            () -> Assertions.assertEquals(solution(new int[]{3, 3, 3, 2, 2, 4}),3),
            () -> Assertions.assertEquals(solution(new int[]{3, 3, 3, 2, 2, 2}),2)
        );
    }

    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> category = new HashSet<>();

        for (int poketmon : nums) {
            category.add(poketmon);
        }

        return Math.min(category.size(), nums.length / 2);
    }


}
