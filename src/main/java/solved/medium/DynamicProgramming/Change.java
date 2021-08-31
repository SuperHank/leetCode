package solved.medium.DynamicProgramming;

/**
 * [518] 零钱兑换 II
 * https://leetcode-cn.com/problems/coin-change-2/
 */
public class Change {

    public static void main(String[] args) {
        System.out.println(new Change().change(5, new int[]{1, 2, 5}));
        System.out.println(new Change().change(3, new int[]{2}));
        System.out.println(new Change().change(10, new int[]{10}));
    }

    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
