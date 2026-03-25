package dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] temp = new int[5][];
        int[][] intervals = {
                {1,3},
                {1,5},
                {6,7}
        };
        System.out.println("Merge intervals: " + Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] <= previous[1]) {
                previous[1] = Math.max(current[1], previous[1]);
            } else {
                result.add(previous);
                previous = current;
            }
        }
        result.add(previous);
        return result.toArray(new int[0][0]);
    }
}
