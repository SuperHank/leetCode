package solved.easy.DynamicProgramming;

import java.util.Arrays;

/**
 * [1646] 获取生成数组中的最大值
 * https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 */
public class GetMaximumGenerated {

    public static void main(String[] args) {
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(2));
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(3));
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(7));
    }

    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }
        int []dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i / 2] + dp[i / 2 + 1];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
