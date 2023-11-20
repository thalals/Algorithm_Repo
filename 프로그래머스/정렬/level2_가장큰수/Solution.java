package 정렬.level2_가장큰수;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    void test() {
        Assertions.assertEquals(solution(new int[]{6, 10, 2}), "6210");
        Assertions.assertEquals(solution(new int[]{3, 30, 34, 5, 9}), "9534330");
        Assertions.assertEquals(solution(new int[]{33, 35, 34, 555, 19}), "55535343319");
        Assertions.assertEquals(solution(new int[]{51, 15}), "5115");
        Assertions.assertEquals(solution(new int[]{0, 0, 0}), "0");
        Assertions.assertEquals(solution(new int[]{0,33}), "330");
        Assertions.assertEquals(solution(new int[]{0,1000}), "10000");
        Assertions.assertEquals(solution(new int[]{81, 818, 817}), "81881817");
        Assertions.assertEquals(solution(new int[]{555, 565, 566, 55, 56, 5, 54, 544, 549}), "5665656555555554954544");
        Assertions.assertEquals(solution(new int[]{1000, 111, 110, 101, 100, 11, 10, 1, 0}), "1111111101011010010000");

    }

    public String solution(int[] numbers) {

        String[] s = Arrays.stream(numbers).mapToObj(operand -> operand + "")
            .sorted(getComparing())
            .toArray(String[]::new);

        if (Arrays.stream(s).allMatch(s1 -> s1.charAt(0) == '0')) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String a : s) {
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

    private static Comparator<String> getComparing() {
        //두 문자열을 더한 값 중 더 큰값의 순서대로 정렬 3 34 | 34 3
        return (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
    }
}