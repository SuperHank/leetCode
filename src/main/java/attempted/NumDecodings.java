package attempted;

/**
 * [91] 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 */
public class NumDecodings {
    public static void main(String[] args) {
//        System.out.println(new NumDecodings().numDecodings("12"));
//        System.out.println(new NumDecodings().numDecodings("226"));
//        System.out.println(new NumDecodings().numDecodings("0"));
//        System.out.println(new NumDecodings().numDecodings("06"));
        System.out.println(new NumDecodings().numDecodings("200"));
        System.out.println(new NumDecodings().numDecodings("11106"));
        System.out.println(new NumDecodings().numDecodings("12201"));
//        System.out.println(new NumDecodings().numDecodings("12301"));
//        System.out.println(new NumDecodings().numDecodings("19101"));
    }

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;
        char[] arr = s.toCharArray();
        for (int i = 1; i < s.length(); ++i) {
            int current = Integer.parseInt(arr[i] + "");
            int previous = Integer.parseInt(arr[i - 1] + "");

            if (current == 0) {
                if (previous == 0 || previous > 2) {
                    return 0;
                } else {
                    dp[i] = dp[i - 1];
                    continue;
                }
            }

            int result = previous * 10 + current;
            if (result > 0 && result <= 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }

        }
        return dp[s.length() - 1];
    }
}
