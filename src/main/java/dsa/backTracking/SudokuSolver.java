package org.dsa.backTracking;

import java.util.Arrays;

/**
 * box 0 | box 1 | box 2
 * ------|-------|------
 * box 3 | box 4 | box 5
 * ------|-------|------
 * box 6 | box 7 | box 8
 *
 * +-------+-------+-------+
 * | Box0  | Box1  | Box2  |
 * | (0-2) | (0-2) | (0-2) |
 * | rows  | cols  | cols  |
 * +-------+-------+-------+
 * | Box3  | Box4  | Box5  |
 * | (3-5) | (3-5) | (3-5) |
 * | rows  | cols  | cols  |
 * +-------+-------+-------+
 * | Box6  | Box7  | Box8  |
 * | (6-8) | (6-8) | (6-8) |
 * | rows  | cols  | cols  |
 * +-------+-------+-------+
 *
 * (0,0) (0,1) (0,2) | (0,3) (0,4) (0,5) | (0,6) (0,7) (0,8)
 * (1,0) (1,1) (1,2) | (1,3) (1,4) (1,5) | (1,6) (1,7) (1,8)
 * (2,0) (2,1) (2,2) | (2,3) (2,4) (2,5) | (2,6) (2,7) (2,8)
 * ------------------+-------------------+------------------
 * (3,0) (3,1) (3,2) | (3,3) (3,4) (3,5) | (3,6) (3,7) (3,8)
 * (4,0) (4,1) (4,2) | (4,3) (4,4) (4,5) | (4,6) (4,7) (4,8)
 * (5,0) (5,1) (5,2) | (5,3) (5,4) (5,5) | (5,6) (5,7) (5,8)
 * ------------------+-------------------+------------------
 * (6,0) (6,1) (6,2) | (6,3) (6,4) (6,5) | (6,6) (6,7) (6,8)
 * (7,0) (7,1) (7,2) | (7,3) (7,4) (7,5) | (7,6) (7,7) (7,8)
 * (8,0) (8,1) (8,2) | (8,3) (8,4) (8,5) | (8,6) (8,7) (8,8)
 *
 * ideally row/3, col/3 is the first we think, but for each box, we skip 3 rows
 * for eg: box 0 -> (0, 1, 2) which is 3 rows, but for position (8,5), if we do 8/3 -> 2 and 5/3 -> 1
 * which is 3 but its box 7!, so 8/3 * 3 -> 2 * 3 -> 6 (which is now box 6) + col(5/3) gives box 7 (8,5)
 * which is correct!
 */
public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();

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
        solver.solve(board);
        System.out.println(Arrays.deepToString(board));
    }

    private void solve(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') {
                    int num = board[row][col] - '1'; // convert char to index 0-8
                    int boxIndex = (row / 3) * 3 + (col / 3);
                    rows[row][num] = true;
                    cols[col][num] = true;
                    box[boxIndex][num] = true;
                }
            }
        }
        backtrack(board, rows, cols, box, 0, 0);
    }

    private boolean backtrack(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] box,
                              int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) return true;
        }

        if (board[row][col] != '.') {
            return backtrack(board, rows, cols, box, row, col + 1);
        }
        int boxIndex = (row / 3) * 3 + (col / 3);
        for (int num = 0; num < 9; num++) {
            if (!rows[row][num] && !cols[col][num] && !box[boxIndex][num]) {
                board[row][col] = (char) (num + '1');
                rows[row][num] = true;
                cols[col][num] = true;
                box[boxIndex][num] = true;

                if (backtrack(board, rows, cols, box, row, col + 1)) {
                    System.out.println("row: "+ row + " - col: "+col);
                    return true;
                }

                board[row][col] = '.';
                rows[row][num] = false;
                cols[col][num] = false;
                box[boxIndex][num] = false;
            }
        }
        return false;
    }
}
