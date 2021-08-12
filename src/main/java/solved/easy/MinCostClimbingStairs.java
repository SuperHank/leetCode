package solved.easy;

/**
 * [746] 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int left = cost[0];
        int right = cost[1];
        // 3. 确定递推公式
        // 4. 确定遍历顺序
        for (int i = 2; i < cost.length; i++) {
            int sum = Math.min(left, right) + cost[i];
            left = right;
            right = sum;
        }

        return Math.min(left, right);
    }
}
