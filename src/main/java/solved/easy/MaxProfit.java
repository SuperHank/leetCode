package solved.easy;

/**
 * [121] 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit__(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit__((new int[]{7, 6, 4, 3, 1})));
    }


    /**
     * 贪心算法
     * 取左最小值 取右边最大值
     */
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            profit = Math.max(prices[i] - low, profit);
        }
        return profit;
    }

    /**
     * 暴力破解
     */
    public int maxProfit_(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit;
    }

    /**
     * 动态规划
     */
    public int maxProfit__(int[] prices) {
        int dp[][] = new int[prices.length][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }

        return dp[prices.length - 1][1];
    }
}
