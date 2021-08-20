package solved.medium;

/**
 * [309] 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class MaxProfitVI {

    public static void main(String[] args) {
        System.out.println(new MaxProfitVI().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }

        return Math.max(dp[prices.length - 1][2], dp[prices.length - 1][1]);
    }
}
