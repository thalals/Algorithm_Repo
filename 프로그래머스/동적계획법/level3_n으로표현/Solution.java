package 동적계획법.level3_n으로표현;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution(1, 121), 4);
        Assertions.assertEquals(solution(6, 5), 3);
        Assertions.assertEquals(solution(5, 12), 4);
        Assertions.assertEquals(solution(2, 11), 3);
    }

    private static final BiFunction<Integer, Integer, Integer> plus = Integer::sum;
    private static final BiFunction<Integer, Integer, Integer> minus = (num1, num2) -> num1 - num2;
    private static final BiFunction<Integer, Integer, Integer> multiply = (num1, num2) -> (Integer) (num1 * num2);
    private static final BiFunction<Integer, Integer, Integer> divide = (num1, num2) -> (Integer) (num1 / num2);
    private static final BiFunction<Integer, Integer, Integer> consecutive = (num1, num2) -> {
        int result = num1;

        for (int i = 1; i < num2; i++) {
            result += (int) (num1 * Math.pow(10, i));
        }

        return result;
    };


    public int solution(int N, int number) {

        if (N == number) {
            return 1;
        }

        List<Set<Integer>> availableNumberList = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            availableNumberList.add(new HashSet<>());
        }

            availableNumberList.get(1).add(N);

        for (int i = 2; i < 9; i++) {
            Set<Integer> set = availableNumberList.get(i);

            for(int j=1; j<=i; j++) {
                //이전에 만들어 놓은 모든 숫자를 연산함 숫서도 바꿔서
                Set<Integer> preSet = availableNumberList.get(j);
                Set<Integer> postSet = availableNumberList.get(i - j);

                //넣어
                for (int beforeNumber : preSet) {
                    for (int moreBeforeNumber : postSet) {
                        set.add(plus.apply(beforeNumber, moreBeforeNumber));

                        set.add(minus.apply(beforeNumber, moreBeforeNumber));

                        set.add(multiply.apply(beforeNumber, moreBeforeNumber));

                        if (beforeNumber != 0 && moreBeforeNumber != 0) {
                            set.add(divide.apply(moreBeforeNumber, beforeNumber));
                        }
                    }
                }

                set.add(consecutive.apply(N, i));
            }
            //찾아
            if (availableNumberList.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
