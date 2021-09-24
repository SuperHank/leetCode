package solved.medium.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * [98] 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(new IsValidBST().isValidBST(root1));
        TreeNode root2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(new IsValidBST().isValidBST(root2));
        TreeNode root3 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(new IsValidBST().isValidBST(root3));
    }

    public boolean isValidBST(TreeNode root) {
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
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
