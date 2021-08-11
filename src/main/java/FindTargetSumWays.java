import java.util.Arrays;

public class FindTargetSumWays {
    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{2, 1}, 1));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1}, 1));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int weight = (sum + target) / 2;

        int dp[][] = new int[nums.length][weight + 1];

        for (int i = weight; i >= nums[0]; i--) {
            dp[0][i] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = weight; j >= nums[i]; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], nums[i] + dp[i - 1][j - nums[i]]);
            }
        }

        return dp[nums.length - 1][weight];
    }
}
