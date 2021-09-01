package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [47] 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermuteUnique {
    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        backTracking(nums, new int[nums.length], path, res);

        return res;
    }

    private void backTracking(int[] nums, int[] used, LinkedList<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);

            path.addLast(nums[i]);
            used[i] = 1;
            backTracking(nums, used, path, res);
            path.removeLast();
            used[i] = 0;
        }
    }
}