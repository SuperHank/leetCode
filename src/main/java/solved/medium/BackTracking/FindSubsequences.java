package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * [491] 递增子序列
 * https://leetcode-cn.com/problems/increasing-subsequences/
 */
public class FindSubsequences {

    public static void main(String[] args) {
        System.out.println(new FindSubsequences().findSubsequences(new int[]{4, 6, 7, 7}));
        System.out.println(new FindSubsequences().findSubsequences(new int[]{4, 4, 3, 2, 1}));
        System.out.println(new FindSubsequences().findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        backTracking(nums, 0, path, res);

        return res;
    }

    private void backTracking(int[] nums, int startIndex, LinkedList<Integer> path, List<List<Integer>> res) {
        if (check(path)) {
            res.add(new ArrayList<>(path));
        }

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

    public boolean check(LinkedList<Integer> temp) {
        if (temp.size() < 2) {
            return false;
        }
        Iterator<Integer> iterator = temp.iterator();

        Integer first = iterator.next();
        do {
            Integer second = iterator.next();
            if (first > second) {
                return false;
            }
            first = second;
        } while (iterator.hasNext());
        return true;
    }
}
