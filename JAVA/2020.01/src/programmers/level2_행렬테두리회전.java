package programmers;

import java.io.IOException;

public class level2_행렬테두리회전 {
    public static void main(String[] args) throws IOException {
        int queries[][]={{2,2,5,4},{3,3,6,6},{5,1,6,3}};
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};  //회전에의해 바뀐 가장 작은숫자들

        int map[][] = new int[rows+1][columns+1];

        int number = 1;
        for(int i=1;i<rows+1;i++){
            for (int j=1; j<columns+1;j++)
                map[i][j] = number++;
        }

        //회전
        for(int i=0;i<queries.length;i++){
            int cycle[] = queries[i];
        }


        return answer;
    }

}
