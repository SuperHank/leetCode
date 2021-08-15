package solved.easy;

import java.util.Arrays;

/**
 * [392] 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class CountBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountBits().countBits(2)));
        System.out.println(Arrays.toString(new CountBits().countBits(5)));
    }

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            int result = i;
            int mod;
            int count = 0;
            do {
                mod = result % 2;
                result = result / 2;
                if (mod == 1) {
                    count++;
                }
            } while (result > 0);
            dp[i] = count;
        }
        return dp;
    }
}
