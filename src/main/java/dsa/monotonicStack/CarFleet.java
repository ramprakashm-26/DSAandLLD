package org.dsa.monotonicStack;

import java.util.*;

public class CarFleet {
    public static void main(String[] args) {
        int[] position = {2, 5, 9, 14, 17};
        int[] speed = {4, 3, 2, 1, 1};
        int target = 20;
        System.out.println(carFleet(target, position, speed));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        if (n <= 1) return n;
        Stack<Float> stack = new Stack<>();
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(position[i], speed[i]);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            float time = (float) (target - entry.getKey()) / entry.getValue();
            while (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }
        return stack.size();
    }

    //without stack
    public int carFleetII(int target, int[] position, int[] speed) {
        int n = speed.length;
        if (n <= 1) return n;
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.put(position[i], speed[i]);
        }
        int noOfFleets = 0;
        float fleetTime = 0.0f;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            float currentFleetTime = (float) (target - entry.getKey()) / entry.getValue();
            if (fleetTime < currentFleetTime) {
                noOfFleets++;
                fleetTime = currentFleetTime;
            }
        }
        return noOfFleets;
    }
}
