package attempted;

/**
 * [1014] 最佳观光组合
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 */
public class MaxScoreSightseeingPair {

    public static void main(String[] args) {
        System.out.println(new MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(new MaxScoreSightseeingPair().maxScoreSightseeingPair(new int[]{1, 2}));
    }

    /**
     * 暴力破解
     */
    public int maxScoreSightseeingPair_(int[] values) {
        if (values.length < 2) {
            return 0;
        }

        int maxValue = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                maxValue = Math.max(values[j] + values[i] + i - j, maxValue);
            }
        }

        return maxValue;
    }

    /**
     * TODO
     * 动态规划
     */
    public int maxScoreSightseeingPair(int[] values) {
        if (values.length < 2) {
            return 0;
        }

        int dp[] = new int[values.length];

        dp[0] = 0;
        for (int i = 1; i < values.length; i++) {
            dp[i] = Math.max(dp[i - 1], values[i] + values[i - 1] + 1);
        }

        return dp[values.length - 1];
    }
}
