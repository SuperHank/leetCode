package solved.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * [118] 杨辉三角
 * https://leetcode-cn.com/problems/pascals-triangle/
 */
public class Generate {
    public static void main(String[] args) {
        System.out.println(new Generate().generate(5));
        System.out.println(new Generate().generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> tmpDp = new ArrayList<>(i);
            tmpDp.add(1);
            for (int j = 1; j <= i; j++) {
                tmpDp.add(j >= dp.get(i - 1).size() ? dp.get(i - 1).get(j - 1) : dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j));
            }
            dp.add(tmpDp);
        }

        return dp;
    }
}
