package attempted;

/**
 * [300] 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        System.out.println(new LengthOfLIS().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = 1;
        int min = nums[0];
        int max = nums[0];
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > max) {
                dp[i] = dp[i - 1] + 1;
                maxLength = Math.max(maxLength, dp[i]);
                max = Math.max(max, nums[i]);
            } else {
                if (nums[i] < min) {
                    min = Math.min(min, nums[i]);
                    max = min;
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return maxLength;
    }
}
