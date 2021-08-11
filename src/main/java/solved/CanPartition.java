package solved;

import java.util.Arrays;

/**
 * [416] 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class CanPartition {
    public static void main(String[] args) {
        System.out.println(new CanPartition().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new CanPartition().canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(new CanPartition().canPartition(new int[]{1, 1, 1, 1}));
        System.out.println(new CanPartition().canPartition(new int[]{14, 9, 8, 4, 3, 2}));
        System.out.println(new CanPartition().canPartition(new int[]{1, 2, 5}));
    }

    public boolean canPartition(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];

        for (int i = nums[0]; i < target + 1; i++) {
            dp[0][i] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        return dp[nums.length - 1][target] == target;
    }
}
