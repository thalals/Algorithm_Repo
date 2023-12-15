package 동적계획법.level3_정수삼각형;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {
        Assertions.assertEquals(solution(new int[][]{{7},{3, 8},{8, 1, 0},{2, 7, 4, 4},{4, 5, 2, 6, 5}}), 30);
    }

    public int solution(int[][] triangle) {

        for (int i = triangle.length - 2; i >= 0; i--) {

            for (int j = 0; j < triangle[i].length; j++) {
                int left = triangle[i+1][j];
                int right = triangle[i+1][j+1];

                triangle[i][j] = Math.max(triangle[i][j] + left, triangle[i][j] + right);
            }
        }


        return triangle[0][0];
    }


}
