package solved;

/**
 * [121] 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int low = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            profit = Math.max(prices[i] - low, profit);
        }
        return profit;
    }
}
