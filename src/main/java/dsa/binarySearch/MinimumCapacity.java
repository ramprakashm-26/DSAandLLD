package dsa.binarySearch;

import java.util.List;

public class MinimumCapacity {
    public static void main(String[] args) {
        List<Integer> weights = List.of(3,2,2,4,1,4);
        int days = 3;
        System.out.println(minimumCapacity(weights, days));
    }

    public static int minimumCapacity(List<Integer> weights, int days) {
        int left = 0;
        int right = 0;
        // Step 1: Define search space
        for (int w : weights) {
            left = Math.max(left, w);   // minimum capacity
            right += w;                 // maximum capacity
        }
        // Step 2: Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canShip(List<Integer> weights, int days, int capacity) {
        int daysUsed = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w <= capacity) {
                currentLoad += w;
            } else {
                daysUsed++;
                currentLoad = w;
            }
        }
        return daysUsed <= days;
    }
}
