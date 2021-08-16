package solved.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * [136] 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new SingleNumber().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return 0;
    }
}
