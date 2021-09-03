package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * [剑指offer 38] 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Permutation {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("abc")));
        System.out.println(Arrays.toString(new Permutation().permutation("aab")));
    }

    public String[] permutation(String s) {
        ArrayList<String> res = new ArrayList<>();

        LinkedList<Character> path = new LinkedList<>();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        backTracking(arr, new int[s.length()], path, res);

        String[] result = new String[res.size()];
        return res.toArray(result);
    }

    private void backTracking(char[] s, int[] used, LinkedList<Character> path, ArrayList<String> res) {
        if (path.size() == s.length) {
            StringBuilder builder = new StringBuilder();
            for (Character character : path) {
                builder.append(character);
            }
            res.add(builder.toString());
            return;
        }

        for (int i = 0; i < s.length; i++) {
            if (i > 0 && s[i] == s[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.addLast(s[i]);

            backTracking(s, used, path, res);

            used[i] = 0;
            path.removeLast();
        }
    }
}
