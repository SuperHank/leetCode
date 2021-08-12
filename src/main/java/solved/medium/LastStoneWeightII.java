package solved.medium;

import java.util.Arrays;

/**
 * [1049] 最后一块石头的重量 II
 * https://leetcode-cn.com/problems/last-stone-weight-ii/
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        stones = Arrays.stream(stones).sorted().toArray();
        int sum = Arrays.stream(stones).sum();
        int target = sum / 2;

        int dp[] = new int[target + 1];

        for (int i = target; i >= stones[0]; i--) {
            dp[i] = stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], stones[i] + dp[j - stones[i]]);
            }
        }

        int maxWeight = dp[target];
        return sum - maxWeight - maxWeight;
    }
}
