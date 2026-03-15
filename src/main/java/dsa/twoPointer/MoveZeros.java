package dsa.twoPointer;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                continue;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left++] = temp;
        }
        // OR
//        if (nums == null || nums.length == 0) {
//            return;
//        }
//        if (nums.length == 1) {
//            return;
//        }
//        int left = 0, right = 1;
//        while (right < nums.length) {
//            if (nums[left] == 0 && nums[right] != 0) {
//                swap(nums, left, right);
//                left++;
//                right++;
//            } else if (nums[left] == 0 && nums[right] == 0) {
//                right++;
//            } else {
//                left++;
//                right++;
//            }
//        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
