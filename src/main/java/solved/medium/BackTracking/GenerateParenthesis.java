package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [22] 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(1));
        System.out.println(new GenerateParenthesis().generateParenthesis(2));
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        LinkedList<String> path = new LinkedList<>();

        backTracking(n, 0, 0, 0, path, res);

        return res;
    }

    private void backTracking(int n, int leftCount, int rightCount, int startIndex, LinkedList<String> path, List<String> res) {
        if (path.size() == 2 * n) {
            if (leftCount == rightCount) {
                res.add(String.join("", path));
            }
            return;
        }

        for (int i = startIndex; i < 2 * n; i++) {
            if (leftCount > n) {
                return;
            } else if (leftCount == n) {
                path.add(")");
                rightCount++;
                backTracking(n, leftCount, rightCount, i + 1, path, res);
                path.removeLast();
                rightCount--;
            } else {
                if (rightCount > leftCount) {
                    return;
                } else if (rightCount == leftCount) {
                    path.add("(");
                    leftCount++;
                    backTracking(n, leftCount, rightCount, i + 1, path, res);
                    path.removeLast();
                    leftCount--;
                } else {
                    path.addLast("(");
                    leftCount++;
                    if (leftCount > n) {
                        return;
                    }
                    backTracking(n, leftCount, rightCount, i + 1, path, res);
                    path.removeLast();
                    leftCount--;

                    path.addLast(")");
                    rightCount++;
                    if (rightCount > leftCount) {
                        return;
                    }
                    backTracking(n, leftCount, rightCount, i + 1, path, res);
                    path.removeLast();
                    rightCount--;
                }
            }
        }
    }
}
