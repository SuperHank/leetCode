package solved.easy.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 * [1] 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
    }

    /**
     * 暴力破解
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 空间换时间
     */
    public int[] twoSum_(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmpTarget = target - nums[i];
            if (map.containsKey(tmpTarget)) {
                return new int[]{map.get(tmpTarget), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
