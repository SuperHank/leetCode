package solved.medium.DynamicProgramming;

/**
 * [413] 等差数列划分
 * https://leetcode-cn.com/problems/arithmetic-slices/
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(new NumberOfArithmeticSlices().numberOfArithmeticSlices(new int[]{1}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        int dp[] = new int[nums.length];
        dp[0] = 0;
        dp[1] = 0;

        int t = 0;
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1;
                result += ++t;
            } else {
                dp[i] = 0;
                t = 0;
            }
        }
        return result;
    }
}
