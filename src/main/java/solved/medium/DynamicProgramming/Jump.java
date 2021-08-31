package solved.medium.DynamicProgramming;

/**
 * [45] 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump {

    public static void main(String[] args) {
        System.out.println(new Jump().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Jump().jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(new Jump().jump(new int[]{1, 1, 1, 1}));
    }

    /**
     * 动态规划
     */
    public int jump(int[] nums) {
        // 跳到当前位置的最小步数
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int tmp = 1;
            while (tmp <= nums[i]) {
                if (i + tmp >= nums.length) {
                    break;
                }
                dp[i + tmp] = Math.min(dp[i] + 1, dp[i + tmp]);
                tmp++;
            }
        }

        return dp[nums.length - 1];
    }

    /**
     * 暴力破解
     */
    public int jump_(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int jumpCount = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int maxCount = nums[i];
            int tmpCount = 1;
            // 跳到i需要的步数
            for (int j = 1; j <= maxCount && i + j < nums.length; j++) {
                if (j + nums[j] >= nums.length) {
                    jumpCount = Math.min(jumpCount, ++tmpCount);
                }
            }
        }
        return jumpCount;
    }
}
