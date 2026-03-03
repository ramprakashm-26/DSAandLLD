package org.dsa.backTracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "EE";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }

    private boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] used) {
        if (index == word.length()) {
            return true;
        }
        int m = board.length, n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n ||
                used[row][col] ||
                board[row][col] != word.charAt(index)) {
            return false;
        }
        used[row][col] = true;
        boolean top = dfs(board, word, index + 1, row - 1, col, used);
        boolean down = dfs(board, word, index + 1, row + 1, col, used);
        boolean left = dfs(board, word, index + 1, row, col - 1, used);
        boolean right = dfs(board, word, index + 1, row, col + 1, used);

        used[row][col] = false;

        return top|| down || left || right;
    }
}
