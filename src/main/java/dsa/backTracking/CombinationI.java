package org.dsa.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationI {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 7};
        List<List<Integer>> result = new ArrayList<>();
        int target = 7;
        backtrack(numbers, target,0,  new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> tempList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]); // choose
            backtrack(candidates, target - candidates[i], i, tempList, result); // not i + 1 because we can reuse same element
            tempList.remove(tempList.size() - 1); // backtrack
        }
    }
}
