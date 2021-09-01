package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [90] 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 */
public class SubsetsWithDup {


    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{0}));
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        nums = Arrays.stream(nums).sorted().toArray();

        backTracking(nums, 0, path, res);

        return res;
    }

    private void backTracking(int[] nums, int startIndex, LinkedList<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1, path, res);
            path.removeLast();
        }
    }
}
