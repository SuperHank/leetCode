package solved.medium;

import java.util.Arrays;

/**
 * [494] 目标和
 * https://leetcode-cn.com/problems/target-sum/
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1}, 1));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 0}, 1));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{0, 1}, 1));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }

    public int findTargetSumWays(int[] nums, int target) {
        nums = Arrays.stream(nums).sorted().toArray();
        int sum = Arrays.stream(nums).sum();

        if ((sum + target) % 2 == 1) {
            return 0;
        }

        int plus = (sum + target) / 2;

        int dp[] = new int[plus + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = plus; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[plus];
    }
}
