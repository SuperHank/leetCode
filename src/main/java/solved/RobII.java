package solved;

public class RobII {
    public static void main(String[] args) {
        System.out.println(new RobII().rob(new int[]{2, 3, 2}));
        System.out.println(new RobII().rob(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(robII(nums, 0, nums.length - 2), robII(nums, 1, nums.length - 1));
    }

    public int robII(int[] nums, int start, int end) {
        if (nums.length == 2) {
            return Math.max(nums[start], nums[start + 1]);
        }

        int left = nums[start];
        int right = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end + 1; i++) {
            int max = Math.max(right, left + nums[i]);
            left = right;
            right = max;
        }

        return Math.max(left, right);
    }

}
