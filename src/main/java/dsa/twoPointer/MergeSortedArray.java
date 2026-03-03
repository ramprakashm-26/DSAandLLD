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

    public void mergedArray(int[] num1, int m, int[] num2, int n) {
        if (m == 0 || n == 0 || (m == 1 && n == 1) || (m == 1 && n == 0)) {
            return;
        }
        int p1 = m - 1, p2 = n - 1, p3 = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (num1[p1] > num2[p2]) {
                num1[p3] = num1[p1];
                p1--;
            } else {
                num1[p3] = num2[p2];
                p2--;
            }
            p3--;
        }
        while (p2 >= 0) {
            num1[p3] = num2[p2];
            p2--;
            p3--;
        }
    }
}
