package dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset1_2_Q12_Q13 {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3}; //unique
        int[] nums = {1, 2, 2}; //Duplicate
        Arrays.sort(nums); //if duplicate then sort first
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i - 1] == nums[i]) { //duplicate check
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
