package solved.medium.DynamicProgramming;

/**
 * [377] 组合总和 IV
 * https://leetcode-cn.com/problems/combination-sum-iv/
 */
public class CombinationSum4 {
    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(new CombinationSum4().combinationSum4(new int[]{9}, 3));
    }

    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] = dp[i] + dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}
