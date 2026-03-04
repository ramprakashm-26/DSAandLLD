package dsa.prefix_suffix;

public class TrapRainWater {
    public static void main(String[] args) {
        TrapRainWater trapRainWater = new TrapRainWater();
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trapRainWater.trap(height));
        System.out.println("O(1) space: " + trapWater(height));
    }

    public static int trapWater(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[left];
                }
                right--;
            }
        }
        return result;
    }

    //O(n)
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length, result = 0;
        int[] left = new int[n], right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
