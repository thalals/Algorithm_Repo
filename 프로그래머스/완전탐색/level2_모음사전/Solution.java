package 완전탐색.level2_모음사전;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution("AAAAE"), 6);
        Assertions.assertEquals(solution("AAAE"), 10);
        Assertions.assertEquals(solution("I"), 1563);
        Assertions.assertEquals(solution("EIO"), 1189);
    }

    public static char[] WORD = new char[]{'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        int answer = 0;

        int[] find = new int[]{-1,-1,-1,-1,-1};

        while (!compare(find, word)) {

            //find 숫자
            change(find);

            answer++;
        }


        return answer;
    }

    private void change(int[] find) {

        //빈자리 채우기
        for (int i = 0; i < find.length; i++) {
            if (find[i] == -1) {
                find[i] ++;
                return;
            }
        }

        //마지막 글자가 U가 아니면 한글자씩 올리기
        for (int i = find.length - 1; i >= 0; i--) {
            if (find[i] == 4) {
                find[i] = -1;
                continue;
            }

            if (find[i] < 4) {
                find[i]++;
                return;
            }
        }

    }

    public boolean compare(int[] find, String word) {

        for (int i = 0; i < word.length(); i++) {
            if (find[i] == -1) {
                return false;
            }

            if (WORD[find[i]] != word.charAt(i)) {

                return false;
            }
        }

        return true;
    }
}

