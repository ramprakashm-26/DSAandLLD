package dsa.backTracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationI {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
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
            current.add(numbers[i]);
            used[i] = true;
            backTrack(numbers, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
