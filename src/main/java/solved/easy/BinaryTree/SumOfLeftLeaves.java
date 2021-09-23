package solved.easy.BinaryTree;

import java.util.LinkedList;

/**
 * [404] 左叶子之和
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int result = 0;

        if (root == null)
            return result;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();

            if (current.left != null) {
                if (current.left.left == null && current.left.right == null) {
                    result += current.left.val;
                } else {
                    stack.addLast(current.left);
                }
            }
            if (current.right != null)
                stack.addLast(current.right);
        }
        return result;
    }
}
