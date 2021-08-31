package solved.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [216] 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class CombinationSum3 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 7));
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int numCount, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        backTracking(targetSum, numCount, 0, 1, path, res);

        return res;
    }

    private void backTracking(int targetSum, int numCount, int currentSum, int startIndex, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == numCount) {
            if (targetSum == currentSum) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (numCount - path.size()) + 1; i++) {
            path.add(i);
            currentSum = currentSum + i;
            backTracking(targetSum, numCount, currentSum, i + 1, path, res);
            path.removeLast();
            currentSum = currentSum - i;
        }
    }
}
