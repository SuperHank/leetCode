package solved.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [77] 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
        System.out.println(new Combine().combine(1, 1));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (k <= 0 || n < k) {
            return res;
        }

        LinkedList<Integer> path = new LinkedList<>();
        backTracing(n, k, 1, path, res);
        return res;
    }

    private void backTracing(int n, int k, int startIndex, LinkedList<Integer> tmpRes, List<List<Integer>> res) {
        if (tmpRes.size() == k) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            tmpRes.addLast(i);
            backTracing(n, k, i + 1, tmpRes, res);
            tmpRes.removeLast();
        }
    }
}
