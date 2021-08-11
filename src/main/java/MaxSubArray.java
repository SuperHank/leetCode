/**
 * 最大自序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaxSubArray().maxSubArray(new int[]{1}));
        System.out.println(new MaxSubArray().maxSubArray(new int[]{0}));
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-1}));
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-10000}));
    }


    public int maxSubArray(int[] nums) {
        /*int dp[] = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();*/
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
