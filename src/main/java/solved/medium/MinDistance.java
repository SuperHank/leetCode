package solved.medium;

/**
 * [583] 两个字符串的删除操作
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class MinDistance {

    public static void main(String[] args) {
        System.out.println(new MinDistance().minDistance("sea", "eat"));
    }

    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[arr1.length][arr2.length];
    }
}
