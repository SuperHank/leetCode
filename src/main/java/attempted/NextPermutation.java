package attempted;

/**
 * [31] 下一个排列
 * https://leetcode-cn.com/problems/next-permutation/
 */
public class NextPermutation {

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 2, 3});
        new NextPermutation().nextPermutation(new int[]{3, 2, 1});
        new NextPermutation().nextPermutation(new int[]{1, 1, 5});
        new NextPermutation().nextPermutation(new int[]{1});
    }

    public void nextPermutation(int[] nums) {
        int rightIndex = nums.length - 1;
        int leftIndex = nums.length - 2;
        if (leftIndex < 0) {
            return;
        }

        while (rightIndex >= 0) {
            while (leftIndex >= 0) {
                if (nums[rightIndex] > nums[leftIndex]) {
                    int tmp = nums[rightIndex];
                    while (rightIndex > leftIndex) {
                        nums[rightIndex] = nums[rightIndex - 1];
                        rightIndex--;
                    }
                    nums[leftIndex] = tmp;
                    return;
                }
                leftIndex--;
            }
            rightIndex--;
        }

        // 倒序排列
    }
}
