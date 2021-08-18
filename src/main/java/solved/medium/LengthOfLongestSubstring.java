package solved.medium;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * [3] 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(""));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("aab"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();

        LinkedList<Character> list = new LinkedList<>();
        int maxLength = 0;
        for (char character : arr) {
            if (list.contains(character)) {
                Iterator<Character> iterator = list.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next() != character) {
                        iterator.remove();
                    } else {
                        iterator.remove();
                        break;
                    }
                }
            }
            list.addLast(character);
            maxLength = Math.max(maxLength, list.size());
        }

        return maxLength;
    }
}
