package org.dsa.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetII {
    public static void main(String[] args) {
        SubSetII subset = new SubSetII();
        int[] nums = {2, 2, 2};
        System.out.println(subset.backtrack(nums));
    }

    private List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackHelper(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrackHelper(int start, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = start;
             i < nums.length;
             i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue; // Skip this duplicate
            }

            subset.add(nums[i]);
            backtrackHelper(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
