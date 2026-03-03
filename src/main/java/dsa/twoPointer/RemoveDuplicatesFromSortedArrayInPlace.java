package dsa.twoPointer;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayInPlace {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayInPlace removeDups = new RemoveDuplicatesFromSortedArrayInPlace();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {1, 2, 2};
        System.out.println(removeDups.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) return 1;
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                int temp = nums[left + 1];
                nums[left + 1] = nums[right];
                nums[right++] = temp;
                left++;
            }
        }
        return left + 1;
    }
}
