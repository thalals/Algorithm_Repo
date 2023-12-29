package kakao.택배배달과_수거하기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0}), 16);
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;

        while (Arrays.stream(deliveries).sum() + Arrays.stream(pickups).sum() != 0) {

            // 박스를 두고오는게 더 멀리있는 경우 + 박스를 가져오는게 더 멀리있는 경우
            int deliveriesLongIndex = IntStream.iterate(deliveries.length - 1, i -> i >= 0, i -> i--)
                    .map(i -> deliveries[i])
                    .filter(value -> value > 0)
                    .findFirst()
                    .getAsInt();

            int pickupLongIndex = IntStream.iterate(pickups.length - 1, i -> i >= 0, i -> i--)
                    .map(i -> pickups[i])
                    .filter(value -> value > 0)
                    .findFirst()
                    .getAsInt();

            int initCap = getDeliveryBox();
            int initBox = 0;

            if (deliveriesLongIndex >= pickupLongIndex) {

                //놓고 오세요
                answer += deliveriesLongIndex;

                for (int i = deliveriesLongIndex; i >= 0; i--) {

                    //두고오기
                    if (initCap - deliveries[i] >= 0) {
                        initCap = -deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] = -initCap;
                        initCap = 0;
                    }

                    //가져오기
                    if (cap - initCap - initBox - pickups[i] >= 0) {

                    }
                }

            }


        }

        return answer;
    }

    private int getDeliveryBox(int cap, int maxIndex, int[] deliveries) {

        int box = 0;

        for (int i = deliveries.length - 1; i >= maxIndex; i--) {
            box += deliveries[i];
        }

        return Math.min(box, cap);
    }
}
