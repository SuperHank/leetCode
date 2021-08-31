package solved.easy.DynamicProgramming;

import javafx.util.Pair;

/**
 * 【125】 验证回文串
 * https://leetcode-cn.com/problems/valid-palindrome/submissions/
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        if (start > end) {
            return true;
        }

        s = s.toLowerCase();
        while (start < end) {
            Pair<Character, Integer> left = getNextNum(s, start, 1);
            Pair<Character, Integer> right = getNextNum(s, end, -1);

            if (left == null || right == null) {
                return true;
            }

            start = left.getValue();
            end = right.getValue();
            if (!left.getKey().equals(right.getKey())) {
                return false;
            }
        }

        return true;
    }

    public static Pair<Character, Integer> getNextNum(String content, Integer index, Integer offset) {
        if (index < 0 || index > content.length() - 1) {
            return null;
        }
        char charAt = content.charAt(index);
        if (isNumOrChar(charAt)) {
            return new Pair<>(charAt, index + offset);
        } else {
            return getNextNum(content, index + offset, offset);
        }
    }


    public static boolean isNumOrChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
