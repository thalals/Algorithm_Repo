package dfs_bfs.level2_타켓넘버;

//dfs
public class 타겟_넘버 {

    public static void main(String[] args) {
        //  [1, 1, 1, 1, 1] 	3
        //  [4, 1, 2, 1]	4
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private static int dfs(int[] number, int target, int depth, int sum) {

        if (depth == number.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(number, target, depth + 1, sum + number[depth]) +
            dfs(number, target, depth + 1, sum - number[depth]);
    }
}
