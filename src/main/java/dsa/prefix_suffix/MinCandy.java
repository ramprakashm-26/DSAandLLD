package dsa.prefix_suffix;

import java.util.Arrays;

public class MinCandy {
    public static void main(String[] args) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        System.out.println("Minimum candy required: " + candy(ratings));
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int result = 0;
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + left[i];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + right[i];
            }
        }
        for (int i = 0; i < n; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
