package solved.medium.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * [120] 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class MinimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new MinimumTotal().minimumTotal(list));
        List<List<Integer>> list2 = new ArrayList<>();
        list2.add(Collections.singletonList(-1));
        list2.add(Arrays.asList(2, 3));
        list2.add(Arrays.asList(1, -1, -3));
        System.out.println(new MinimumTotal().minimumTotal(list2));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];

        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                if (j == i) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
            }
        }

        return Arrays.stream(dp[triangle.size() - 1]).min().getAsInt();
    }
}
