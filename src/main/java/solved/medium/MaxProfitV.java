package solved.medium;

/**
 * [714] 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class MaxProfitV {

    public static void main(String[] args) {
        System.out.println(new MaxProfitV().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(new MaxProfitV().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }

        return dp[prices.length - 1][1];
    }
}
