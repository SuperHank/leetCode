package solved.medium;

import javafx.util.Pair;

/**
 * [5] 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindrome().longestPalindrome("a"));
        System.out.println(new LongestPalindrome().longestPalindrome("ac"));
        System.out.println(new LongestPalindrome().longestPalindrome("aaaaa"));
        System.out.println(new LongestPalindrome().longestPalindrome("aaaa"));
    }

    /**
     * 中心扩散法 从中间往两边找
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        Pair<Integer, Integer> result = new Pair<Integer, Integer>(0, 0);
        int max = 1;
        // 从头开始遍历
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int left = i, right = i;
            while (left - 1 >= 0) {
                if (arr[left - 1] == arr[i]) {
                    left--;
                } else {
                    break;
                }
            }
            while (right + 1 < arr.length) {
                if (arr[right] == arr[right + 1]) {
                    right++;
                } else {
                    break;
                }
            }

            // 左右都不相等
            while (left - 1 >= 0 && right + 1 < arr.length) {
                if (arr[left - 1] == arr[right + 1]) {
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (max < right - left + 1) {
                result = new Pair<>(left, right);
                max = right - left + 1;
            }
        }
        if (result.getValue() == s.length() - 1) {
            return s.substring(result.getKey());
        } else {
            return s.substring(result.getKey(), result.getValue() + 1);
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                break;
            }
        }
        return start >= end;
    }

}
