package attempted;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [51] N皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class SolveNQueens {

    public static void main(String[] args) {
        System.out.println(new SolveNQueens().solveNQueens(1));
        System.out.println(new SolveNQueens().solveNQueens(4));
        System.out.println(new SolveNQueens().solveNQueens(8));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        LinkedList<String> path = new LinkedList<>();

        backTracking(n, 0, new int[n], path, res);

        return res;
    }

    private void backTracking(int n, int startIndex, int[] used, LinkedList<String> path, List<List<String>> res) {

        if (path.size() == n) {

            return;
        }

        for (int i = startIndex; i < n; i++) {
            if (used[i] == 1) {
                continue;
            }
            used[i] = 1;
            StringBuilder builder = new StringBuilder();
            for (int index = 0; index < n; index++) {
                if (index != i) {
                    builder.append(".");
                } else {
                    builder.append("Q");
                }
            }
            path.add(builder.toString());
            backTracking(n, i + 1, used, path, res);
            path.removeLast();
        }
    }

    private boolean check(LinkedList<String> path) {
        ArrayList<Pair<Integer, Integer>> position = new ArrayList<>();
        for (String s : path) {

        }
    }
}
