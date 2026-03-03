package org.dsa.backTracking;

import java.util.*;

/**
 * Diagonal (\)calculation of unique index
 *    0   1   2   3   ← col
 *  +---+---+---+---+
 * 0| 0 |-1 |-2 |-3 |
 * 1| 1 | 0 |-1 |-2 |
 * 2| 2 | 1 | 0 |-1 |
 * 3| 3 | 2 | 1 | 0 |
 *  ↑
 * row
 *
 * AntiDiagonal (/) calculation of unique index
 *    0   1   2   3   ← col
 *  +---+---+---+---+
 * 0| 0 | 1 | 2 | 3 |
 * 1| 1 | 2 | 3 | 4 |
 * 2| 2 | 3 | 4 | 5 |
 * 3| 3 | 4 | 5 | 6 |
 *  ↑
 * row
 */
public class NQueens {
    public static void main(String[] args) {
        int nQueen = 4;
        System.out.println("SolveNQueen by Set: "+ solveNQueen(nQueen));
        System.out.println("SolveNQueen by Boolean: "+ solveNQueenByBoolean(nQueen));
    }

    private static List<List<String>> solveNQueen(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        Set<Integer> colVisited = new HashSet<>();
        Set<Integer> diagonalVisited = new HashSet<>();
        Set<Integer> antiDiagonalVisited = new HashSet<>();
        backtrack(board, colVisited, diagonalVisited, antiDiagonalVisited, result, 0);
        return result;
    }

    private static void backtrack(char[][] board, Set<Integer> colVisited, Set<Integer> diagonalVisited,
                           Set<Integer> antiDiagonalVisited, List<List<String>> result, int row) {
        if (row == board.length) {
            result.add(constructResult(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            int diagIndex = row - col;
            int antiDiagIndex = row + col;
            if (colVisited.contains(col) || diagonalVisited.contains(diagIndex) ||
                    antiDiagonalVisited.contains(antiDiagIndex)) {
                continue;
            }
            colVisited.add(col);
            diagonalVisited.add(diagIndex);
            antiDiagonalVisited.add(antiDiagIndex);
            board[row][col] = 'Q';
            backtrack(board, colVisited, diagonalVisited, antiDiagonalVisited, result, row + 1);
            colVisited.remove(col);
            diagonalVisited.remove(diagIndex);
            antiDiagonalVisited.remove(antiDiagIndex);
            board[row][col] = '.';
        }
    }

    private static List<String> constructResult(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    private static List<List<String>> solveNQueenByBoolean(int nQueen) {
        char[][] board = new char[nQueen][nQueen];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        boolean[] colVisited = new boolean[nQueen];
        boolean[] diagonal = new boolean[2 * nQueen - 1];
        boolean[] antiDiagonal = new boolean[2 * nQueen - 1];
        List<List<String>> result = new ArrayList<>();
        backtrack(0, nQueen, board, colVisited, diagonal, antiDiagonal, result);
        return result;
    }

    private static void backtrack(int row, int n, char[][] board, boolean[] colVisited,
                                  boolean[] diagonal, boolean[] antiDiagonal,
                                  List<List<String>> result) {
        if (row == board.length) {
            result.add(convertToList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int diagIndex = row - col + (n - 1);
            int antiDiagIndex = row + col;
            if (colVisited[col] || diagonal[diagIndex] || antiDiagonal[antiDiagIndex]) {
                continue;
            }
            board[row][col] = 'Q';
            colVisited[col] = true;
            diagonal[diagIndex] = true;
            antiDiagonal[antiDiagIndex] = true;

            backtrack(row + 1, n, board, colVisited, diagonal, antiDiagonal, result);

            board[row][col] = '.';
            colVisited[col] = false;
            diagonal[diagIndex] = false;
            antiDiagonal[antiDiagIndex] = false;
        }
    }

    private static List<String> convertToList(char[][] board) {
        List<String> subResult = new ArrayList<>();
        for (char[] row : board) {
            subResult.add(new String(row));
        }
        return subResult;
    }
}
