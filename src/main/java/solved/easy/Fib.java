package solved.easy;

/**
 * [509] 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 */
public class Fib {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int left = 0;
        int right = 1;
        for (int i = 2; i <= n; i++) {
            right += left;
            left = right - left;
        }
        return right;
    }
}
