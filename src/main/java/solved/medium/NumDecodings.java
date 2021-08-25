package solved.medium;

/**
 * [91] 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("12"));
        System.out.println(new NumDecodings().numDecodings("226"));
        System.out.println(new NumDecodings().numDecodings("0"));
        System.out.println(new NumDecodings().numDecodings("06"));
        System.out.println(new NumDecodings().numDecodings("200"));
        System.out.println(new NumDecodings().numDecodings("11106"));
        System.out.println(new NumDecodings().numDecodings("12201"));
        System.out.println(new NumDecodings().numDecodings("12301"));
        System.out.println(new NumDecodings().numDecodings("19101"));
        System.out.println(new NumDecodings().numDecodings("10"));
    }

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        char[] arr = s.toCharArray();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (arr[i] == '0') {
                dp[i] = 0;
                if (arr[i + 1] == '0') {
                    return 0;
                }
                continue;
            }

            if (Integer.parseInt(arr[i] + "") * 10 + Integer.parseInt(arr[i + 1] + "") > 26) {
                dp[i] = dp[i + 1];
            } else {
                if (i + 2 > s.length() - 1) {
                    dp[i] = dp[i + 1] + 1;
                } else {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
