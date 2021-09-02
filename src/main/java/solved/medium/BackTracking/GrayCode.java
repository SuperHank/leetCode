package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [89] 格雷编码
 * https://leetcode-cn.com/problems/gray-code/
 */
public class GrayCode {

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2));
        System.out.println(new GrayCode().grayCode(0));
    }

    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        backTracking(n, new int[n], 0, path, res);

        return res;
    }

    private void backTracking(int n, int[] used, int startIndex, LinkedList<Integer> path, ArrayList<Integer> res) {
        if (startIndex == 0) {
            int sum = 0;
            for (int i = 0; i < used.length; i++) {
                sum += used[i] * Math.pow(2, i);
            }
            res.add(sum);
        }

        if (path.size() > 0) {
            int sum = 0;
            for (int i = 0; i < used.length; i++) {
                sum += used[i] * Math.pow(2, i);
            }
            res.add(sum);
            if (startIndex == n) {
                return;
            }
        }

        for (int i = startIndex; i < n; i++) {
            if (used[i] == 1) {
                continue;
            }

            used[i] = 1;
            path.add(used[i]);
            backTracking(n, used, i + 1, path, res);
            used[i] = 0;
            path.removeLast();
        }
    }
}
