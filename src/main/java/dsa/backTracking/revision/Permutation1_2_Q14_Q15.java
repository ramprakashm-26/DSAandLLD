package org.dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation1_2_Q14_Q15 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, visited, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backtrack(int[] nums, boolean[] visited,
                                  List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && !visited[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            current.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, current, result);
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }
}
