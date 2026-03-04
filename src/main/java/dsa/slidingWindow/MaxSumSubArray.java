package dsa.slidingWindow;

public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum subarray : " + maxSumSubArray(array, k));
    }

    private static int maxSumSubArray(int[] array, int k) {
        int n = array.length;
        int max = 0, currentSum = 0;
        for (int left = 0, right = 0; right < n; right++) {
            currentSum += array[right];
            if (right - left + 1 == k) {
                max = Math.max(max, currentSum);
                currentSum -= array[left++];
            }
        }
        return max;
    }
}
