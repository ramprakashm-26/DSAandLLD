package dsa.backTracking.practice;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        List<String> result = new ArrayList<>();
        dfs(maze, 0, 0, m, n, visited, new StringBuilder(), null, result);
        System.out.println(result);
    }

    private static void dfs(int[][] maze, int i, int j, int rowLen, int colLen, boolean[][] visited,
                            StringBuilder sb, Character ch, List<String> result) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || maze[i][j] == 0 || visited[i][j]) {
            return;
        }
        if (ch != null) {
            sb.append(ch);
        }
        if (i == rowLen - 1 && j == colLen - 1) {
            result.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);//this move is traditional backtracking approach
            return;                                //where we undo previous result!
        }
        visited[i][j] = true;
        dfs(maze, i - 1, j, rowLen, colLen, visited, sb, 'U', result);
        dfs(maze, i + 1, j, rowLen, colLen, visited, sb, 'D', result);
        dfs(maze, i, j - 1, rowLen, colLen, visited, sb, 'L', result);
        dfs(maze, i, j + 1, rowLen, colLen, visited, sb, 'R', result);
        if (ch != null) {
            sb.deleteCharAt(sb.length() - 1);
            visited[i][j] = false;
        }
    }

//    private static void dfs(int[][] maze, int row, int col, int m, int n, boolean[][] visited,
//                            StringBuilder sb, Character ch, List<String> result) {
//
//        if ((row < 0 || row >= m) || (col < 0 || col >= n) || visited[row][col] || maze[row][col] == 0) {
//            return;
//        }
//
//        if (ch != null) {
//            sb.append(ch);
//        }
//
//        if (row == m - 1 && col == n - 1) {
//            result.add(sb.toString());
//            if (ch != null)
//                sb.deleteCharAt(sb.length() - 1);
//            return;
//        }
//        visited[row][col] = true;
//
//        dfs(maze, row - 1, col, m, n, visited, sb, 'U', result);
//        dfs(maze, row + 1, col, m, n, visited, sb, 'D', result);
//        dfs(maze, row, col - 1, m, n, visited, sb, 'L', result);
//        dfs(maze, row, col + 1, m, n, visited, sb, 'R', result);
//
//        if (ch != null) {
//        sb.deleteCharAt(sb.length() - 1);
//        }
//        visited[row][col] = false;
//    }
}
