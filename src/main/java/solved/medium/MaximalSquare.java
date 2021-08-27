package solved.medium;

/**
 * 【221】 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'0', '1'}, {'1', '0'}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'0', '0', '1', '1', '1'}}));
    }

    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxSize = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                maxSize = 1;
            } else {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (dp[i - 1][j - 1] >= 1 && dp[i - 1][j] >= 1 && dp[i][j - 1] >= 1 && matrix[i][j] == '1') {
                    if (dp[i - 1][j - 1] == dp[i - 1][j] && dp[i - 1][j] == dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize * maxSize;
    }
}
