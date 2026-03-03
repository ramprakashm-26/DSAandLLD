package dsa.twoPointer;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] array = {-7, -3, 2, 3, 11};
        SquaresOfSortedArray sortedArray = new SquaresOfSortedArray();
        System.out.println(Arrays.toString(sortedArray.sortedSquares(array)));
    }

    /**
     * {16, 1, 0, 9, 100} O/P -> {0, 1, 9, 16, 100} , {0,1,3,-4,10}
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, pos = nums.length - 1;
        while (left <= right) {
            int leftSqr = nums[left] * nums[left], rightSqr = nums[right] * nums[right];
            if (leftSqr > rightSqr) {
                result[pos] = leftSqr;
                left++;
            } else {
                result[pos] = rightSqr;
                right--;
            }
            pos--;
        }
        return result;
    }
}
