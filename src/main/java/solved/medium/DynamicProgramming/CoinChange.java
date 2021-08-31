package solved.medium.DynamicProgramming;

/**
 * [322] 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 0));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 1));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 2));
        System.out.println(new CoinChange().coinChange(new int[]{2, 5, 10, 1}, 27));
        System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            dp[i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }
}
