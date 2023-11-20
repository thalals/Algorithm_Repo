package 완전탐색.level1_최소직사각형;

public class Solution {

    public int solution(int[][] sizes) {
        int maxW = 0; // 최대 가로 길이
        int maxH = 0; // 최대 세로 길이

        // 주어진 명함의 가로 길이와 세로 길이 중에서 최대값을 찾기
        for (int[] size : sizes) {
            maxW = Math.max(maxW, Math.max(size[0], size[1]));
            maxH = Math.max(maxH, Math.min(size[0], size[1]));
        }

        // 최대 가로 길이와 최대 세로 길이를 곱해 지갑의 크기를 계산
        int answer = maxW * maxH;
        return answer;
    }
}
