package solved;

import java.util.HashMap;

/**
 * [496] 下一个更大元素 I
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[i] < nums2[j]) {
                    map.put(nums2[i], nums2[j]);
                    break;
                }
            }
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]) == null ? -1 : map.get(nums1[i]);
        }
        return result;
    }
}
