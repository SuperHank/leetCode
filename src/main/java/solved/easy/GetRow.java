package solved.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * [119] 杨辉三角 II
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class GetRow {
    public static void main(String[] args) {
        System.out.println(new GetRow().getRow(3));
        System.out.println(new GetRow().getRow(1));
        System.out.println(new GetRow().getRow(0));
    }

    public List<Integer> getRow(int rowIndex) {
        int dp[][] = new int[rowIndex + 1][rowIndex + 1];

        for (int i = 0; i < rowIndex + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < rowIndex + 1; i++) {
            for (int j = 1; j < rowIndex+1; j++) {
                dp[i][j]= dp[i-1][j-1]+dp[i-1][j];
            }
        }
        return Arrays.stream(dp[rowIndex]).boxed().collect(Collectors.toList());
    }
}
