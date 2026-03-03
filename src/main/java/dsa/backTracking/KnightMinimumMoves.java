package org.dsa.backTracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Infinite chessboard knight move
 */
public class KnightMinimumMoves {
    public static void main(String[] args) {
        int x = -5, y = 5;
        System.out.println(minimumNoOfMoves(x, y));
    }

    private static int minimumNoOfMoves(int targetX, int targetY) {
        targetX = Math.abs(targetX);
        targetY = Math.abs(targetY);
        int[][] directions = {
                {-2, 1}, {-2, -1}, {2, -1}, {2, 1},
                {1, -2}, {-1, -2}, {-1, 2}, {1, 2}
        };
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int moves = 0;
        queue.add(new int[]{0, 0});
        visited.add("0,0");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] direction = queue.poll();
                int currX = direction[0];
                int currY = direction[1];
                if (currX == targetX && currY == targetY) {
                    return moves;
                }
                for (int[] currDir : directions) {
                    int newX = currX + currDir[0];
                    int newY = currY + currDir[1];
                    if (newX >= -2 && newY >= -2) {
                        String path = newX + "," + newY;
                        if (!visited.contains(path)) {
                            queue.add(new int[] {newX, newY});
                            visited.add(path);
                        }
                    }
                }
            }
            moves++;
        }
        return moves;
    }
}
