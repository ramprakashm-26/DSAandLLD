package dsa.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 2};
        Arrays.sort(numbers);
        List<List<Integer>> resultSet = new ArrayList<>();
        boolean[] used = new boolean[numbers.length];
        backTrack(numbers, used, new ArrayList<>(), resultSet);
        System.out.println(resultSet);
    }

    public static void backTrack(int[] numbers, boolean[] used, List<Integer> current,
                                 List<List<Integer>> result) {
        if (current.size() == numbers.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && numbers[i] == numbers[i - 1] && !used[i - 1]) {
                continue;
            }
            current.add(numbers[i]);
            used[i] = true;
            backTrack(numbers, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
