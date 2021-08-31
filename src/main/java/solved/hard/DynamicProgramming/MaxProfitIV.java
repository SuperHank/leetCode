package solved.hard.DynamicProgramming;

/**
 * [188] 买卖股票的最佳时机 IV
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class MaxProfitIV {

    public static void main(String[] args) {
        System.out.println(new MaxProfitIV().maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(new MaxProfitIV().maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        int dp[][] = new int[prices.length][2 * k];
        for (int i = 0; i < 2 * k; i++) {
            if (i % 2 == 0) {
                dp[0][i] = -prices[0];
            }
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < 2 * k; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], -prices[i]);
                    continue;
                }
                if (j % 2 == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                }
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
        }

        return dp[prices.length - 1][2 * k - 1];
    }
}
