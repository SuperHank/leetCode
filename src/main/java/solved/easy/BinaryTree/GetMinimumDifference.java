package solved.easy.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * [530] 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 */
public class GetMinimumDifference {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        System.out.println(new GetMinimumDifference().getMinimumDifference(root));
    }

    public int getMinimumDifference(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode current = stack.getLast();
            if (current != null) {
                current = stack.removeLast();
                if (current.right != null) {
                    stack.addLast(current.right);
                }
                stack.addLast(current);
                stack.addLast(null);

                if (current.left != null) {
                    stack.addLast(current.left);
                }
            } else {
                stack.removeLast();
                if (!stack.isEmpty()) {
                    TreeNode last = stack.removeLast();
                    result.add(last.val);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < result.size() - 1; i++) {
            int abs = Math.abs(result.get(i) - result.get(i + 1));
            res = Math.min(res, abs);
        }
        return res;
    }
}
