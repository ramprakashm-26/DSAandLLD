package dsa.backTracking.revision;

public class WordSearch_3 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ECC";
        System.out.println(isExist(board, word));
    }

    private static boolean isExist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (backtrack(board, word, visited, row, col, m, n, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, boolean[][] visited, int row,
                                     int col, int m, int n, int index) {
        if (index == word.length()) {
            return true;
        }
        if ((row < 0 || row >= m) || (col < 0 || col >= n) || visited[row][col] ||
                board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean up = backtrack(board, word, visited, row - 1, col, m, n, index + 1);
        boolean down = backtrack(board, word, visited, row + 1, col, m, n, index + 1);
        boolean left = backtrack(board, word, visited, row, col - 1, m, n, index + 1);
        boolean right = backtrack(board, word, visited, row, col + 1, m, n, index + 1);
        visited[row][col] = false;
        return up || down || left || right;
    }
}
