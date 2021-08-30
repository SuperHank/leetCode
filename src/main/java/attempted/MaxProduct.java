package attempted;

/**
 * [152] 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new MaxProduct().maxProduct(new int[]{-2, 0, -1}));
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i], nums[i - 1]);
        }
        return max;
    }

}
