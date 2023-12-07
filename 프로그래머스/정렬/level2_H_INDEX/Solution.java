package 정렬.level2_H_INDEX;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(solution(new int[]{3, 4}), 2);
        Assertions.assertEquals(solution(new int[]{3, 0, 6, 1, 5}), 3);
    }

    public int solution(int[] citations) {

        Arrays.sort(citations);

        int answer = 0;

        //h 의 최대값은 쓴 논문의 최대값
        for (int i = citations.length; i > 0; i--) {

            int finalI = i;
            long count = Arrays.stream(citations).filter(value -> value >= finalI).count();

            if(count >= i)
                return i;

        }

        return answer;
    }
}
