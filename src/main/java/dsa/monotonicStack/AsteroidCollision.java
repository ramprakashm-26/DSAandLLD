package org.dsa.monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {3, 5, -6, 2, -1, 4};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            boolean currentAlive = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {
                if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
                    stack.pop();
                } else if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                    currentAlive = false;
                    break;
                } else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                    stack.pop();
                    currentAlive = false;
                    break;
                }
            }
            if (currentAlive) {
                stack.push(asteroids[i]);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
