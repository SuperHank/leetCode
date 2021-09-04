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
        ArrayList<String> res = new ArrayList<>();

        LinkedList<String> path = new LinkedList<>();

        backTracking(n, 0, 0, path, res);

        return res;
    }

    private void backTracking(int n, int leftCount, int rightCount, LinkedList<String> path, ArrayList<String> res) {
        if (leftCount > n || rightCount > n || rightCount > leftCount) {
            return;
        }
        if (leftCount == rightCount && leftCount == n) {
            res.add(String.join("", path));
            return;
        }

        if (leftCount == n) {
            path.addLast(")");
            backTracking(n, leftCount, rightCount + 1, path, res);
            path.removeLast();
        } else {
            path.addLast("(");
            backTracking(n, leftCount + 1, rightCount, path, res);
            path.removeLast();

            path.addLast(")");
            backTracking(n, leftCount, rightCount + 1, path, res);
            path.removeLast();
        }
    }
}
