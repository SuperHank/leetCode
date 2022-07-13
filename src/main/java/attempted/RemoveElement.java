package attempted;

/**
 * [27] 移除元素
 * https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {

                nums[i] = nums[i + 1];
                length--;
            }
        }
        return length;
    }
}
