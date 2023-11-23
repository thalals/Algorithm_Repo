package 완전탐색.level2_카펫;

public class Solution {

    public int[] solution(int brown, int yellow) {

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = yellow / i + 2;
                int y = i + 2;

                if (x * y == brown + yellow) {

                    return new int[]{x, y};
                }
            }
        }

        return null;
    }
}
