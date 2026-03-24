package dsa.twoPointer;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] num2 = {1, 2, 3};
        int n = 3;
        MergeSortedArray sortedArray = new MergeSortedArray();
        sortedArray.mergedArray(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }

    public void mergedArray(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
        while (p2 >= 0) {
            nums1[p3--] = nums2[p2--];
        }
    }
}
