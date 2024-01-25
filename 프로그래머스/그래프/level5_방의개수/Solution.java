package 그래프.level5_방의개수;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {

    @Test
    public void test() {

//        Assertions.assertEquals(solution(new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}), 3);
//        Assertions.assertEquals(solution(new int[]{5, 2, 7, 1, 6, 3}), 3);
        Assertions.assertEquals(solution(new int[]{6, 2, 4, 0, 5, 0, 6, 4, 2, 4, 2, 0}), 3);
    }

    public int solution(int[] arrows) {

        int[] arrowMoveX = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        int[] arrowMoveY = new int[]{1, 1, 0, -1, -1, -1, 0, 1};

        int answer = 0;

        //이어진 선 이기때문에, 이미 지나갔던 좌표를 다시 지나가면 하나의 방이다. 이를 만남이라하고, 중복된 만남은 카운팅 하지 않는다.

        //지나간 좌표
        Map<Point, List<Point>> pastMemory = new HashMap<>();

        Point now = new Point(0, 0);

        for (int arrow : arrows) {

            //간선 교차 테스트를 위한 스케일업 x2
            int scaleUp = 2;
            while (scaleUp-- > 0) {
                Point next = now.next(arrowMoveX[arrow], arrowMoveY[arrow]);

                if (!pastMemory.containsKey(next)) {
                    List<Point> list = new ArrayList<>();
                    list.add(now.copy());
                    pastMemory.put(next, list);

                    if (pastMemory.get(now) == null) {
                        List<Point> list2 = new ArrayList<>();
                        list.add(next);
                        pastMemory.put(now.copy(), list2);
                    } else{
                        pastMemory.get(now).add(next);
                    }
                }
                else if(pastMemory.containsKey(next) && !pastMemory.get(next).contains(now)) {
                    pastMemory.get(next).add(now.copy());
                    pastMemory.get(now).add(next);
                    answer++;
                }

                now.move(arrowMoveX[arrow], arrowMoveY[arrow]);
            };

        }


        return answer;
    }
}

class Point{

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int moveX, int moveY) {
        x += moveX;
        y += moveY;
    }
    public Point next(int moveX, int moveY) {
        return new Point(x + moveX, y + moveY);
    }
    public Point copy() {
        return new Point(x, y );
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
