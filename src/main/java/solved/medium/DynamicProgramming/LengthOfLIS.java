package solved.medium.DynamicProgramming;

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

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
