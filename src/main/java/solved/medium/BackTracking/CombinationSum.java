package solved.medium.BackTracking;

import java.util.*;

/**
 * [39] 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(new CombinationSum().combinationSum(new int[]{2}, 1));
        System.out.println(new CombinationSum().combinationSum(new int[]{1}, 1));
        System.out.println(new CombinationSum().combinationSum(new int[]{1}, 2));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();
        candidates = Arrays.stream(candidates).sorted().toArray();
        backTracking(candidates, target, 0, path, res);
        return res;
    }

    private void backTracking(int[] candidates, int target, int currentSum, LinkedList<Integer> path, List<List<Integer>> res) {
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

        for (int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);
            currentSum += candidates[i];
            backTracking(candidates, target, currentSum, path, res);
            path.removeLast();
            currentSum -= candidates[i];
        }
    }
}
