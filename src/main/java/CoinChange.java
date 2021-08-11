import java.util.Arrays;

/**
 * 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 0));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 1));
        System.out.println(new CoinChange().coinChange(new int[]{1}, 2));
    }

    public int coinChange(int[] coins, int amount) {
        coins = Arrays.stream(coins).sorted().toArray();

        // 定义数组
        int dp[] = new int[amount + 1];

        // 遍历顺序
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j < coins[i]) {
                    dp[j] = 0;
                } else {
                    dp[j] = Math.min(dp[j], coins[i] + dp[j - coins[i]]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
