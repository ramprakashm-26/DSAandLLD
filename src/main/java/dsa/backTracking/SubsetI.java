package dsa.backTracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetI {
    public static void main(String[] args) {
        SubsetI subset1 = new SubsetI();
        int[] nums = {1, 2, 2};
        System.out.println(subset1.backtrack(nums));
    }

    private List<List<Integer>> backtrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackHelper(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrackHelper(int start, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = start;
             i < nums.length;
             i++) {
            subset.add(nums[i]);
            backtrackHelper(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
