package solved.easy;

/**
 * [392] 判断子序列
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }

        int dp[][] = new int[t.length()][s.length()];

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        // 初始化
        dp[0][0] = tArr[0] == sArr[0] ? 1 : 0;
        for (int i = 1; i < t.length(); i++) {
            dp[i][0] = tArr[i] == sArr[0] ? 1 : dp[i - 1][0];
        }

        for (int i = 1; i < s.length(); i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < t.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (sArr[j] == tArr[i]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[t.length() - 1][s.length() - 1] == 1;
    }
}
