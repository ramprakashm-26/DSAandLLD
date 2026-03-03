package org.dsa.backTracking.revision;

import java.util.Arrays;

public class SudokuSolver_2 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    private static void solve(char[][] board) {
        int len = board.length;
        boolean[][] rowVisited = new boolean[len][len];
        boolean[][] colVisited = new boolean[len][len];
        boolean[][] boxVisited = new boolean[len][len];
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (board[row][col] != '.') {
                    int boxIndex = (row / 3) * 3 + col / 3;
                    int value = board[row][col] - '1';
                    rowVisited[row][value] = true;
                    colVisited[col][value] = true;
                    boxVisited[boxIndex][value] = true;
                }
            }
        }
        backtrack(board, rowVisited, colVisited, boxVisited, 0, 0, len);
    }

    private static boolean backtrack(char[][] board, boolean[][] rowVisited, boolean[][] colVisited,
                                     boolean[][] boxVisited, int row, int col, int n) {
        if (col == n) {
            col = 0;
            row++;
            if (row == n) {
                return true;
            }
        }
        if (board[row][col] != '.') {
            return backtrack(board, rowVisited, colVisited, boxVisited, row, col + 1, n);
        }
        for (int i = 0; i < 9; i++) {
            int boxIndex = (row / 3) * 3 + col / 3;
            if (rowVisited[row][i] || colVisited[col][i] || boxVisited[boxIndex][i]) {
                continue;
            }
            char value = (char) (i + '1');
            rowVisited[row][i] = true;
            colVisited[col][i] = true;
            boxVisited[boxIndex][i] = true;
            board[row][col] = value;
            if (backtrack(board, rowVisited, colVisited, boxVisited, row, col + 1, n)) {
                return true;
            }
            board[row][col] = '.';
            rowVisited[row][i] = false;
            colVisited[col][i] = false;
            boxVisited[boxIndex][i] = false;
        }
        return false;
    }
}
