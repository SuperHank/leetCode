package solved.easy.DynamicProgramming;

/**
 * [674] 最长连续递增序列
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class FindLengthOfLCIS {

    public static void main(String[] args) {
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            } else {
                dp[i] = 1;
            }
        }
        return max;
    }
}
