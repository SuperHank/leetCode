package solved;

/**
 * [198] 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 */
public class Rob {
    public static void main(String[] args) {
        System.out.println(new Rob().rob_(new int[]{1, 2, 3, 1}));
        System.out.println(new Rob().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new Rob().rob(new int[]{2, 1, 1, 2}));
    }

    /**
     * 一阶数组
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[] = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    /**
     * 滚动数组
     */
    public int rob_(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int max = Math.max(nums[i] + first, second);
            first = second;
            second = max;
        }
        return Math.max(first, second);
    }
}
