package solved.easy.DynamicProgramming;

/**
 * [1137] 第 N 个泰波那契数
 * https://leetcode-cn.com/problems/n-th-tribonacci-number/
 */
public class Tribonacci {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int first = 0, second = 1, third = 1;

        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = first + second + third;
            first = second;
            second = third;
            third = result;
        }

        return result;
    }
}
