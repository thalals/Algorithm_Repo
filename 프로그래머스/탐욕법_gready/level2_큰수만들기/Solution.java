package 탐욕법_gready.level2_큰수만들기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {

    @Test
    public void test() {
        Assertions.assertAll(
//                () -> Assertions.assertEquals(solution("1924", 2), "94"),
//                () -> Assertions.assertEquals(solution("1231234", 3), "3234"),
//                () -> Assertions.assertEquals(solution("4177252841", 4), "775841"),
//                () -> Assertions.assertEquals(solution("720378", 2), "7378"),
//                () -> Assertions.assertEquals(solution("928857", 3), "988"),
//                () -> Assertions.assertEquals(solution("99991", 3), "99"),
//                () -> Assertions.assertEquals(solution("10001", 3), "11"),
                () -> Assertions.assertEquals(solution("909090", 1), "99090")
        );
    }

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int[] numberInt = Arrays.stream(number.split("")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        while (k > 0) {
            //남기기로 선택한 숫자
            int selectNumberIndex = start;

            for (int i = start; i <= start + k; i++) {
                if (numberInt[i] > numberInt[selectNumberIndex]) {
                    selectNumberIndex = i;
                }
            }

            //선택된 숫자 앞의 숫자는 지우기
            for (int i = start; i < selectNumberIndex; i++) {
                numberInt[i] = -1;
            }

            k = k - (selectNumberIndex - start);
            start = selectNumberIndex+1;

            //남은 뒷자리가 다 지워야한다면
            if (number.length() - k - start == 0) {
                for (int i = start; i < number.length(); i++) {
                    numberInt[i] = -1;
                }
                break;
            }
        }

        Arrays.stream(numberInt).filter(i -> i>=0).forEach(s -> answer.append(String.valueOf(s)));


        return answer.toString();
    }
}
