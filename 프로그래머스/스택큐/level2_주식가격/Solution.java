package 스택큐.level2_주식가격;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(solution(new int[]{1, 2, 3, 2, 3}), new int[]{4, 3, 1, 1, 0});
        Assertions.assertEquals(solution(new int[]{3, 2, 4, 1, 1}), new int[]{1, 2, 1, 1, 0});
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            int count = 0;
            for (int index = i+1; index < prices.length; index++) {
                count++;
                if (price > prices[index]) {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
