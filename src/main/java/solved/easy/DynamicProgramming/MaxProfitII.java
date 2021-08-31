package solved.easy.DynamicProgramming;

/**
 * [122] 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfitII {
    public static void main(String[] args) {
        System.out.println(new MaxProfitII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfitII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new MaxProfitII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }
}
