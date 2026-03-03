package org.dsa.backTracking.practice;

public class AndroidLockPattern {
    public int counter = 0, result = 0;

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int m = 1, n = 2;
        AndroidLockPattern pattern = new AndroidLockPattern();
        pattern.countPattern(grid, m, n);
        System.out.println(pattern.result);
    }

    private void countPattern(int[][] grid, int m, int n) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                this.counter = 0;
                this.backtrack(new boolean[rowLen][colLen], i, j, rowLen, colLen, m, n);
            }
        }
    }

    private void backtrack(boolean[][] visited, int row, int col, int rowLen, int colLen,
                           int m, int n) {
        if ((row < 0 || row >= rowLen) || (col < 0 || col >= colLen) || visited[row][col]) {
            return;
        }

        visited[row][col] = true;
        counter++;

        if (counter >= m && counter <= n) {
            result++;
        }

        if (counter == n) {
            visited[row][col] = false;
            counter--;
            return;
        }

        for (int nextRow = 0; nextRow < rowLen; nextRow++) {
            for (int nextCol = 0; nextCol < colLen; nextCol++) {
                int rowDiff = Math.abs(nextRow - row);
                int colDiff = Math.abs(nextCol - col);
                if ((rowDiff == 2 && colDiff == 0)     // vertical skip
                        || (rowDiff == 0 && colDiff == 2)  // horizontal skip
                        || (rowDiff == 2 && colDiff == 2)) //diagonal skip
                {
                    int rowMid = (row + nextRow) / 2;
                    int colMid = (col + nextCol) / 2;
                    if (!visited[rowMid][colMid]) {
                        continue;
                    }
                }
                backtrack(visited, nextRow, nextCol, rowLen, colLen, m, n);
            }
        }

        counter = counter - 1;
        visited[row][col] = false;
    }
}

