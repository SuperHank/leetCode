package solved.medium;

/**
 * [718] 最长重复子数组
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class FindLength {

    public static void main(String[] args) {
        System.out.println(new FindLength().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(new FindLength().findLength(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0}));
    }

    public int findLength(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length + 1][nums2.length + 1];
        dp[0][0] = 0;
        int result = 0;
        for (int i = 1; i < nums1.length + 1; i++) {
            for (int j = 1; j < nums2.length + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
