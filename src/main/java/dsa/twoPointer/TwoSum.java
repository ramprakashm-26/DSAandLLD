package dsa.twoPointer;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.findPairs(numbers, target)));
    }

    public int[] findPairs(int[] numbers, int target) {
        long start = System.currentTimeMillis();
        System.out.println("Started execution");
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                System.out.println("Finished execution at: " + (System.currentTimeMillis() - start));
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
