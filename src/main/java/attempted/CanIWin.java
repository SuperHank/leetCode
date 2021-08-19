package attempted;

/**
 * [464] 我能赢吗
 * https://leetcode-cn.com/problems/can-i-win/
 */
public class CanIWin {

    public static void main(String[] args) {
        System.out.println(new CanIWin().canIWin(10, 11));
        System.out.println(new CanIWin().canIWin(10, 40));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int dp[] = new int[desiredTotal + 1];
        for (int i = 0; i < desiredTotal + 1; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            for (int j = 1; j >= i && j < desiredTotal + 1; j++) {
                if (dp[j - i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i] + 1);
                }
            }
        }
        if (dp[desiredTotal] == Integer.MAX_VALUE) {
            return false;
        }
        return dp[desiredTotal] % 2 == 1;
    }
}
