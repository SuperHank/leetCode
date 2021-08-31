package solved.easy.DynamicProgramming;

import java.util.Arrays;

/**
 * [455] 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 */
public class FindContentChildren {
    public static void main(String[] args) {
        System.out.println(new FindContentChildren().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(new FindContentChildren().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(new FindContentChildren().findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }

    public int findContentChildren(int[] g, int[] s) {
        g = Arrays.stream(g).sorted().toArray();
        s = Arrays.stream(s).sorted().toArray();
        int result = 0;
        int index = 0;

        for (int i = 0; i < g.length; i++) {
            while (index < s.length) {
                if (g[i] <= s[index]) {
                    result++;
                    index++;
                    break;
                }
                index++;
            }
        }
        return result;
    }
}
