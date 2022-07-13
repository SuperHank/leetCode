package solved.medium.Array;

/**
 * [11] 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new MaxArea().maxArea(new int[]{1, 1}));
        System.out.println(new MaxArea().maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(new MaxArea().maxArea(new int[]{1, 2, 1}));
    }

    public int maxArea(int[] height) {
        int max = 0;

        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
