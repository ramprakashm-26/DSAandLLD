package hapagLloyd.problems;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = List.of(4, 4, 6, 2, 5);
        int a = 3, b = 2;
        System.out.println(findMinimum(list, a, b));
    }

    private static long findMinimum(List<Integer> data, int a, int b) {
        int n = data.size();
        long totalSum = 0;
        for (int x : data) totalSum += x;

        long leftSum = 0;
        long minMaxTime = Long.MAX_VALUE;

        // Iterate through all possible split points
        for (int i = 0; i < n; i++) {
            leftSum += data.get(i);
            long rightSum = totalSum - leftSum;

            long currentTime = Math.max(leftSum * a, rightSum * b);
            minMaxTime = Math.min(minMaxTime, currentTime);
        }
        return minMaxTime;
    }
}
