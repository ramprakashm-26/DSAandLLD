package dsa.twoPointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater mostWater = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(mostWater.maxArea(height));
    }

    public int maxArea(int[] height) {
        if (null == height || height.length == 1) {
            return 0;
        }
        int left = 0, right = height.length - 1, max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
