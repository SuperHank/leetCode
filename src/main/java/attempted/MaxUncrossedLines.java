package attempted;

/**
 * [1035] 不相交的线
 * https://leetcode-cn.com/problems/uncrossed-lines/
 */
public class MaxUncrossedLines {

    public static void main(String[] args) {
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{1, 3}, new int[]{1}));
    }

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp = new int[Math.max(nums1.length, nums2.length)];

        int[] longArr = nums1;
        int[] shortArr = nums2;

        if (nums1.length < nums2.length) {
            longArr = nums2;
            shortArr = nums1;
        }

        dp[0] = longArr[0] == shortArr[0] ? 1 : 0;
        for (int i = 0; i < shortArr.length; i++) {
            for (int j = 1; j < longArr.length; j++) {
                if (shortArr[i] == longArr[j]) {
                    dp[j] = Math.max(dp[j - 1] + 1, dp[j]);
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
        }
        return dp[longArr.length - 1];
    }
}
