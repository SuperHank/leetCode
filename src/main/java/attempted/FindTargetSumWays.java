package attempted;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * [剑指offer II 102] 加减的目标值
 * https://leetcode-cn.com/problems/YaVDxD/
 */
public class FindTargetSumWays {

    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1, 1}, 3));
        System.out.println(new FindTargetSumWays().findTargetSumWays(new int[]{1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        Arrays.sort(nums);
        LinkedList<Integer> path = new LinkedList<>();
        return backTracking(nums, 0, target, path, new int[nums.length], 0);
    }

    private int backTracking(int[] nums, int startIndex, int targetSum, LinkedList<Integer> path, int[] used, Integer result) {
        if (path.size() == nums.length) {
            Integer sum = 0;
            for (Integer integer : path) {
                sum += integer;
            }
            if (targetSum == sum) {
                return ++result;
            }
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            used[i] = 1;
            path.addLast(+nums[i]);
            result = backTracking(nums, i + 1, targetSum, path, used, result);
            used[i] = 0;
            path.removeLast();

            used[i] = 1;
            path.addLast(-nums[i]);
            result = backTracking(nums, i + 1, targetSum, path, used, result);
            used[i] = 0;
            path.removeLast();
        }

        return result;
    }
}
