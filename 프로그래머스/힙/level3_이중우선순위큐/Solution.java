package 힙.level3_이중우선순위큐;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.PriorityQueue;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {

        assertAll(
            () -> assertEquals(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}), new int[]{333, -45}),
            () -> assertEquals(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}), new int[]{0, 0})
        );

    }

    public int[] solution(String[] operations) {

        boolean[] removeElement = new boolean[operations.length];

        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<operations.length; i++) {

            String[] operator = operations[i].split(" ");

            if (operator[0].charAt(0) == 'I') {
                minHeap.add(new Element(operator[1], i));
                maxHeap.add(new Element(operator[1], i));
            }

            if (operator[0].charAt(0) == 'D' && operator[1].equals("1")) {

                while (!maxHeap.isEmpty()) {
                    Element element = maxHeap.poll();
                    if (!removeElement[element.key]) {
                        removeElement[element.key] = true;
                        break;
                    }
                }
            }

            if (operator[0].charAt(0) == 'D' && operator[1].equals("-1")) {

                while (!minHeap.isEmpty()) {
                    Element element = minHeap.poll();
                    if (!removeElement[element.key]) {
                        removeElement[element.key] = true;
                        break;
                    }
                }
            }
        }

        int max = 0;
        int min = 0;

        while (!minHeap.isEmpty()) {
            Element poll = minHeap.poll();
            if (!removeElement[poll.key]) {
                min = poll.value;
                break;
            }
        }


        while (!maxHeap.isEmpty()) {
            Element poll = maxHeap.poll();
            if (!removeElement[poll.key]) {
                max = poll.value;
                break;
            }
        }

        return new int[]{max, min};
    }
}

class Element implements Comparable<Element> {
    int value;
    int key;

    public Element(String value, int key) {
        this.value = Integer.parseInt(value);
        this.key = key;
    }

    @Override
    public int compareTo(Element o) {
        return o.value > this.value ? -1 : 1;
    }
}