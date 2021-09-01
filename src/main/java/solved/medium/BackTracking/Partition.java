package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [131] 分割回文串
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 */
public class Partition {
    public static void main(String[] args) {
        System.out.println(((new Partition()).partition("aab")));
        System.out.println(((new Partition()).partition("a")));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        LinkedList<String> path = new LinkedList<>();

        backTracking(s.toCharArray(), 0, path, res);

        return res;
    }

    private void backTracking(char[] arr, int startIndex, LinkedList<String> path, List<List<String>> res) {
        if (startIndex >= arr.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < arr.length; i++) {
            if (isPalindrome(arr, startIndex, i)) {
                path.addLast(new String(arr, startIndex, i + 1 - startIndex));
            } else {
                continue;
            }
            backTracking(arr, i + 1, path, res);
            path.removeLast();
        }
    }

    private boolean isPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
