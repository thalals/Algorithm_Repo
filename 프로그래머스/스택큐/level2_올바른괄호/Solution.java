package 스택큐.level2_올바른괄호;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        assertAll(
            () -> assertEquals(solution("()()"),true),
            () -> assertEquals(solution("(())()"),true),
            () -> assertEquals(solution(")()("),false),
            () -> assertEquals(solution("(()("),false)
        );
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
