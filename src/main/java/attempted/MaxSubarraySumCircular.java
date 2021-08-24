package attempted;

/**
 * [918] 环形子数组的最大和
 * https://leetcode-cn.com/problems/maximum-sum-circular-subarray/
 */
public class MaxSubarraySumCircular {
    public static void main(String[] args) {
        System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        return 1;
    }
}
