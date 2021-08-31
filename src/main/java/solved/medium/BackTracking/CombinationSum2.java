package solved.medium.BackTracking;

import java.util.*;

/**
 * [40] 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{1, 2}, 4));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        candidates = Arrays.stream(candidates).sorted().toArray();
        backTracking(candidates, target, 0, 0, path, res);

        return res;
    }

    private void backTracking(int[] candidates, int target, int startIndex, int currentSum, LinkedList<Integer> path, List<List<Integer>> res) {
        if (target < currentSum) {
            return;
        } else if (target == currentSum) {
            ArrayList<Integer> list = new ArrayList<>(path);
            Collections.sort(list);
            if (!res.contains(list)) {
                res.add(list);
            }
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            currentSum += candidates[i];
            backTracking(candidates, target, i + 1, currentSum, path, res);
            path.removeLast();
            currentSum -= candidates[i];
        }
    }
}
