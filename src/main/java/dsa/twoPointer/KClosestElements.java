package dsa.twoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 3, 4}; //{1,1,2,3,4,5}, k =4, x = - 1 && {1, 2, 3, 4, 5}, k = 4, x = 3
        int k = 4, x = 3;
        System.out.println("K Closest elements: %s".formatted(findClosestElements(array, k, x)));
        System.out.println("K Closest elements by min heap: %s".formatted(findClosestByPriorityQueue(array, k, x)));
    }

    public static List<Integer> findClosestElements(int[] array, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = array.length - 1;
        while (right - left + 1 > k) {
            int l = Math.abs(array[left] - x);
            int r = Math.abs(array[right] - x);
            if (l > r) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = left; i <= right; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private static List<Integer> findClosestByPriorityQueue(int[] array, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            if (k > 0) {
                pq.offer(num);
                k--;
            } else if (Math.abs(pq.peek() - x) > Math.abs(num - x)) {
                pq.poll();
                pq.offer(num);
            }
        }
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }
}
