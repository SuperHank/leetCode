package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [46] 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
        System.out.println(new Permute().permute(new int[]{0, 1}));
        System.out.println(new Permute().permute(new int[]{1}));
    }

    public List<List<Integer>> permute(int[] nums) {
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

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            path.addLast(nums[i]);
            backTracking(nums, used, path, res);
            path.removeLast();
            used[i] = 0;
        }
    }
}
