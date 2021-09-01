package solved.hard.BackTracking;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * [52] N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/
 */

public class TotalNQueens {
    public static void main(String[] args) {
        System.out.println(new TotalNQueens().totalNQueens(1));
        System.out.println(new TotalNQueens().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        LinkedList<String> path = new LinkedList<>();

        backTracking(n, new int[n], path, res);

        return res.size();
    }

    private void backTracking(int n, int[] used, LinkedList<String> path, List<List<String>> res) {
        if (path.size() == n) {
            if (check(path)) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = 0; i < n; i++) {
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
            backTracking(n, used, path, res);
            path.removeLast();
            used[i] = 0;
        }
    }

    private boolean check(LinkedList<String> path) {
        ArrayList<Pair<Integer, Integer>> position = new ArrayList<>();
        Iterator<String> iterator = path.iterator();
        int rowIndex = 0;
        while (iterator.hasNext()) {
            String next = iterator.next();
            int colIndex = next.indexOf("Q");
            position.add(new Pair<Integer, Integer>(rowIndex, colIndex));
            rowIndex++;
        }

        for (int i = 1; i < position.size(); i++) {
            Pair<Integer, Integer> currentQ = position.get(i);
            for (int j = 0; j < i; j++) {
                Pair<Integer, Integer> checkQ = position.get(j);
                if (currentQ.getValue() - checkQ.getValue() == i - j || currentQ.getValue() - checkQ.getValue() == j - i) {
                    return false;
                }
            }
        }
        return true;
    }
}
