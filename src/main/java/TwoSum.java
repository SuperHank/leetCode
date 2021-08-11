import java.util.Arrays;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
