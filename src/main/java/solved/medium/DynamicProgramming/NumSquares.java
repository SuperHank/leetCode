package solved.medium.DynamicProgramming;

/**
 * [279] 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
        System.out.println(new NumSquares().numSquares(13));
    }

    public int numSquares(int n) {
        int x = new Double(Math.floor(Math.sqrt(n))).intValue();
        int[] weight = new int[x];

        for (int i = 0; i < x; i++) {
            weight[i] = (i + 1) * (i + 1);
        }

        int dp[] = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            if (i % weight[0] == 0) {
                dp[i] = i / weight[0];
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = weight[i]; j < n + 1; j++) {
                if (dp[j - weight[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
                }
            }
        }
        return dp[n];
    }
}
