package solved.medium;

import java.util.Arrays;

/**
 * [55] 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new CanJump().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new CanJump().canJump(new int[]{1, 0, 1, 0}));
        System.out.println(new CanJump().canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
    }

    /**
     * 暴力破解
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int dp[] = new int[nums.length - 1];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            if (dp[i - 1] >= i) {
                dp[i] = Math.max(i + nums[i], dp[i - 1]);
            } else {
                dp[i] = 0;
            }
        }
        return Arrays.stream(dp).max().getAsInt() >= nums.length - 1;
    }
}
