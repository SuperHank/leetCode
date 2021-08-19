package attempted;

/**
 * [32] 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses("(()"));
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int maxLength = Integer.MIN_VALUE;

        // 0~i 最长的有效
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

        }

        return maxLength;
    }
}
