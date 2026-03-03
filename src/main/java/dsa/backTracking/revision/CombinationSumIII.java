package org.dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int n = 3, t = 7;
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, t, 1, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void backtrack(int times, int target, int index,
                                  List<Integer> current, List<List<Integer>> result) {
        if (times == 0 && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < 10; i++) {
            current.add(i);
            backtrack(times - 1, target - i, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
