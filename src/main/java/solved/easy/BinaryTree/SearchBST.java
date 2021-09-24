package solved.easy.BinaryTree;

import java.util.LinkedList;

/**
 * [700] 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class SearchBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        TreeNode result = new SearchBST().searchBST(root, 2);
        System.out.println(result);
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeFirst();
            if (current.val == val) {
                return current;
            } else if (current.val < val) {
                if (current.right != null)
                    stack.addLast(current.right);
            } else {
                if (current.left != null)
                    stack.addLast(current.left);
            }
        }
        return null;
    }
}
