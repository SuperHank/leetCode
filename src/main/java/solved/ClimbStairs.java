package solved;

/**
 * [70] 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(2));
        System.out.println(new ClimbStairs().climbStairs(3));
        System.out.println(new ClimbStairs().climbStairs(10));
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
