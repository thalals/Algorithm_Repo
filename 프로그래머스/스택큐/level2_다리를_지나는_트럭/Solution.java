package 스택큐.level2_다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution(2, 10, new int[]{7, 4, 5, 6}), 8);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();
        for (int truck : truck_weights) {
            queue.add(truck);
        }

        int count = 0;
        int nowBridgeWeight = 0;

        Queue<Truck> truckQueue = new LinkedList<>();
        while (!queue.isEmpty()) {

            count++;

            //들어온거 중에 지금시간에 이미 도착한거 빼기
            if (!truckQueue.isEmpty() && truckQueue.peek().isArrival(count, bridge_length)) {
                nowBridgeWeight -= truckQueue.poll().weight;
            }

            if(isOnTheBridge(weight, queue.peek(), nowBridgeWeight)) {
                int truckWeight = queue.poll();
                truckQueue.add(new Truck(truckWeight, count));
                nowBridgeWeight += truckWeight;
            }

        }

        //마지막꺼 올라감
        return count + bridge_length;
    }

    private static boolean isOnTheBridge(int weight, int truckWeight, int nowBridgeWeight) {
        return weight - nowBridgeWeight - truckWeight >= 0;
    }
}

class Truck {

    int weight;
    int startTime;

    public Truck(int weight, int startTime) {
        this.weight = weight;
        this.startTime = startTime;
    }

    boolean isArrival(int now, int distance) {
        return now - startTime >= distance;
    }

    void go() {
        startTime += 1;
    }
}
