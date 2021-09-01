package solved.medium.BackTracking;

import java.util.*;

/**
 * [78] 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
        System.out.println(new Subsets().subsets(new int[]{0}));
        System.out.println(new Subsets().subsets(new int[]{4, 1, 0}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        nums = Arrays.stream(nums).sorted().toArray();

        backTracking(nums, 0, path, res);

        res.add(Collections.emptyList());
        return res;
    }

    private void backTracking(int[] nums, int startIndex, LinkedList<Integer> path, List<List<Integer>> res) {
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.addLast(nums[i]);
            res.add(new ArrayList<>(path));
            backTracking(nums, i + 1, path, res);
            path.removeLast();
        }
    }
}
