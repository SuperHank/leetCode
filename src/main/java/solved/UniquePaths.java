package solved;

/**
 * [62] 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths_(7, 3));
        System.out.println(new UniquePaths().uniquePaths_(3, 3));
    }

    /**
     * 二阶数组
     */
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * 一阶数组
     */
    public int uniquePaths_(int m, int n) {
        int dp[] = new int[m];

        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[m - 1];
    }
}
