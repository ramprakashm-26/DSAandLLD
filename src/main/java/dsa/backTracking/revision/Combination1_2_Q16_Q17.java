package org.dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination1_2_Q16_Q17 {
    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5}; //unique
//        int[] nums = {2, 3, 3, 7}; //duplicate
        Arrays.sort(nums); //duplicate
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backtrack(int[] nums, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i - 1] == nums[i]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, target - nums[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
