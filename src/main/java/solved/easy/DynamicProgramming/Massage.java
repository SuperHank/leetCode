package solved.easy.DynamicProgramming;

/**
 * 面试题 17.16 按摩师
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */
public class Massage {
    public static void main(String[] args) {
        System.out.println(new Massage().massage(new int[]{1, 2, 3, 1}));
        System.out.println(new Massage().massage(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new Massage().massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
