package dsa.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * At ACV Transport, we have a fleet management system. Given a list of transport jobs where each job is [startTime, endTime], find the minimum number of drivers needed to complete all jobs.
 * A driver can only handle one job at a time. Once a driver finishes their current job, they can immediately be assigned to a new one.
 * Return the minimum number of drivers required
 */
public class MinimumNoOfDriver {
    public static void main(String[] args) {
        int[][] drivers = {
                {1, 6},
                {2, 4},
                {5, 8},
                {7, 10}
        };
        System.out.println("Minimum no of drivers required: " + minimumNoOfDriver(drivers));
    }

    private static int minimumNoOfDriver(int[][] drivers) {
        Arrays.sort(drivers, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int[] driver : drivers) {
            if (!minHeap.isEmpty() && minHeap.peek() <= driver[0]) {
                minHeap.poll();
            }
            minHeap.offer(driver[1]);
        }
        return minHeap.size();
    }
}
