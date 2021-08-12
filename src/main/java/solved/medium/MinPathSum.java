package solved.medium;

/**
 * [64] 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {
    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1, 2}, {1, 1}}));
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
