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
        int n = nums.length;
        int left = 0;
        for (int right = 1; right < n; right++) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right];
            }
        }
        return left + 1;
    }
}
