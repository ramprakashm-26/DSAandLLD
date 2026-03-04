package dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze_4 {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(findMazePath(maze));
    }

    private static List<String> findMazePath(int[][] maze) {
        List<String> result = new ArrayList<>();
        int len = maze.length;
        boolean[][] visited = new boolean[len][len];
        backtrack(maze, visited, 0, 0, len, null, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(int[][] maze, boolean[][] visited, int row, int col, int len,
                                  Character ch, StringBuilder sb, List<String> result) {
        if ((row < 0 || row >= len) || (col < 0 || col >= len) || visited[row][col] || maze[row][col] == 0) {
            return;
        }
        if (ch != null) {
            sb.append(ch);
        }
        if (row == len - 1 && col == len - 1) {
            result.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        visited[row][col] = true;
        backtrack(maze, visited, row - 1, col, len, 'U', sb, result);
        backtrack(maze, visited, row + 1, col, len, 'D', sb, result);
        backtrack(maze, visited, row, col - 1, len, 'L', sb, result);
        backtrack(maze, visited, row, col + 1, len, 'R', sb, result);
        if (ch != null) {
            sb.deleteCharAt(sb.length() - 1);
        }
        visited[row][col] = false;
    }
}
