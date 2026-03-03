package org.dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Output:
 * [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
 */
public class NQueen_1 {
    public static void main(String[] args) {
        int nQueen = 4;
        System.out.println(solveNQueens(nQueen));
    }

    private static List<List<String>> solveNQueens(int nQueen) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[nQueen][nQueen];
        for (char[] array : board) {
            Arrays.fill(array, '.');
        }
        boolean[] colsVisited = new boolean[nQueen];
        boolean[] diagonalsVisited = new boolean[2 * nQueen - 1];
        boolean[] antiDiagonalsVisited = new boolean[2 * nQueen - 1];
        backtrack(board, colsVisited, diagonalsVisited, antiDiagonalsVisited, 0, nQueen, result);
        return result;
    }

    private static void backtrack(char[][] board, boolean[] colsVisited, boolean[] diagonalsVisited,
                                  boolean[] antiDiagonalsVisited, int row, int n,
                                  List<List<String>> result) {
        if (row == n) {
            result.add(convertToList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int diagonalIndex = row - col + n - 1;
            int antiDiagonalIndex = row + col;
            if (colsVisited[col] || diagonalsVisited[diagonalIndex] || antiDiagonalsVisited[antiDiagonalIndex]) {
                continue;
            }
            board[row][col] = 'Q';
            colsVisited[col] = true;
            diagonalsVisited[diagonalIndex] = true;
            antiDiagonalsVisited[antiDiagonalIndex] = true;
            backtrack(board, colsVisited, diagonalsVisited, antiDiagonalsVisited, row + 1, n, result);
            board[row][col] = '.';
            colsVisited[col] = false;
            diagonalsVisited[diagonalIndex] = false;
            antiDiagonalsVisited[antiDiagonalIndex] = false;
        }
    }

    private static List<String> convertToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] array : board) {
            result.add(new String(array));
        }
        return result;
    }
}
