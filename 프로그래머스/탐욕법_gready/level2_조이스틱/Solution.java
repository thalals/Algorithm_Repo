package 탐욕법_gready.level2_조이스틱;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    // 65 -A
    // 90 - Z

    @Test
    public void test() {
        Assertions.assertEquals(solution("JAZ"), 11);
        Assertions.assertEquals(solution("JEROEN"), 56);
        Assertions.assertEquals(solution("JAN"), 23);
        Assertions.assertEquals(solution("AAA"), 0);
        Assertions.assertEquals(solution("JANS"), 32);
        Assertions.assertEquals(solution("BBBBAAAABA"), 12);
        Assertions.assertEquals(solution("BBBBAAAAAB"), 10);
        Assertions.assertEquals(solution("ABAAAAAAAAABB"), 7);
    }

    public int solution(String name) {

        int answer = 0;

        char origin[] = new char[name.length()];
        Arrays.fill(origin, 'A');

        int count = (int) Arrays.stream(name.split("")).filter(s -> s.charAt(0) != 'A').count();


        //문자 이동 휫수 -> 위, 아래 중 max
        int nowPosition = 0;
        while (count > 0) {

            char wantAlphabet = name.charAt(nowPosition);
            char nowAlphabet = origin[nowPosition];

            if (wantAlphabet != 'A' && nowAlphabet != wantAlphabet) {
                answer += Math.min((wantAlphabet - 'A'), ('Z' - wantAlphabet )+1);
                origin[nowPosition] = wantAlphabet;
                count--;
                continue;
            }

            //오른쪽으로
            int right = nowPosition;
            int rightCount = 0;

            while (origin[right] != 'A' || name.charAt(right) == 'A') {
                right = right + 1 >= name.length() ? 0 : right + 1;
                rightCount++;
            }

            //왼쪽으로
            int left = nowPosition;
            int leftCount = 0;

            while (origin[left] != 'A' || name.charAt(left) == 'A') {
                left = left - 1 <= 0 ? name.length() - 1 : left - 1;
                leftCount++;
            }


            nowPosition = rightCount <= leftCount ? right : left;
            answer += Math.min(rightCount, leftCount);

        }

//        정답풀이
//        순방향으로 갔을때의 최대값
//        int move = name.length() - 1;
//        for(int i = 0; i < name.length(); i++){
//            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
//
//            index = i + 1;
//            // 연속되는 A 갯수 확인
//            while(index < length && name.charAt(index) == 'A'){
//                index++;
//            }
//
//            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
//            move = Math.min(move, i * 2 + length - index);
//            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
//            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
//            move = Math.min(move, (length - index) * 2 + i);
//        }
        return answer;
    }
}
