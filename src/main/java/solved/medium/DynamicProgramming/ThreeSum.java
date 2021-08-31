package solved.medium.DynamicProgramming;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * [15] 三数之和
 * https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{}));
        System.out.println(new ThreeSum().threeSum(new int[]{0}));
        System.out.println(new ThreeSum().threeSum(new int[]{1, 1, -2}));
        System.out.println(new ThreeSum().threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();

        ArrayList<Integer> gtZero = new ArrayList<>();
        ArrayList<Integer> ltZero = new ArrayList<>();
        ArrayList<Integer> eZero = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                gtZero.add(num);
            } else if (num < 0) {
                ltZero.add(num);
            } else {
                eZero.add(num);
            }
        }

        HashMap<Integer, List<Pair<Integer, Integer>>> gtSumAndSingle = new HashMap<>();
        HashMap<Integer, List<Pair<Integer, Integer>>> ltSumAndSingle = new HashMap<>();


        for (int i = 0; i < gtZero.size(); i++) {
            for (int j = i + 1; j < gtZero.size(); j++) {
                int sum = gtZero.get(i) + gtZero.get(j);
                if (gtSumAndSingle.containsKey(sum)) {
                    List<Pair<Integer, Integer>> pairList = gtSumAndSingle.get(sum);
                    Pair<Integer, Integer> pair = new Pair<>(gtZero.get(i), gtZero.get(j));

                    if (!pairList.contains(pair)) {
                        pairList.add(pair);
                    }
                    gtSumAndSingle.put(sum, pairList);
                } else {
                    List<Pair<Integer, Integer>> list = new ArrayList<>();
                    list.add(new Pair<>(gtZero.get(i), gtZero.get(j)));
                    gtSumAndSingle.put(sum, list);
                }
            }
        }

        for (int i = 0; i < ltZero.size(); i++) {
            for (int j = i + 1; j < ltZero.size(); j++) {
                int sum = ltZero.get(i) + ltZero.get(j);
                if (ltSumAndSingle.containsKey(sum)) {
                    List<Pair<Integer, Integer>> pairList = ltSumAndSingle.get(sum);
                    Pair<Integer, Integer> pair = new Pair<>(ltZero.get(i), ltZero.get(j));

                    if (!pairList.contains(pair)) {
                        pairList.add(pair);
                    }
                    ltSumAndSingle.put(sum, pairList);
                } else {
                    List<Pair<Integer, Integer>> list = new ArrayList<>();
                    list.add(new Pair<>(ltZero.get(i), ltZero.get(j)));
                    ltSumAndSingle.put(sum, list);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        // 左1右2
        for (Integer gt0 : gtZero) {
            if (ltSumAndSingle.containsKey(-gt0)) {
                List<Pair<Integer, Integer>> pairList = ltSumAndSingle.get(-gt0);
                for (Pair<Integer, Integer> pair : pairList) {
                    List<Integer> list = Arrays.asList(pair.getKey(), pair.getValue(), gt0);
                    if (!result.contains(list)) {
                        result.add(list);
                    }

                }
            }
        }

        // 左2右1
        for (Integer lt0 : ltZero) {
            if (gtSumAndSingle.containsKey(-lt0)) {
                List<Pair<Integer, Integer>> pairList = gtSumAndSingle.get(-lt0);
                for (Pair<Integer, Integer> pair : pairList) {
                    List<Integer> list = Arrays.asList(lt0, pair.getKey(), pair.getValue());
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                }
            }
        }
        // 左1 右1
        if (eZero.size() > 0) {
            for (Integer gt0 : gtZero) {
                if (ltZero.contains(-gt0)) {
                    List<Integer> list = Arrays.asList(-gt0, 0, gt0);
                    if (!result.contains(list)) {
                        result.add(list);
                    }
                }
            }
        }


        if (eZero.size() >= 3) {
            result.add(Arrays.asList(0, 0, 0));
        }

        return result;
    }

    /**
     * 暴力破解
     * 没法通过leetCode
     */
    public List<List<Integer>> threeSum_(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!result.contains(list))
                            result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
