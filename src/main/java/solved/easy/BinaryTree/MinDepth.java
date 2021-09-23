package solved.easy.BinaryTree;

import java.util.LinkedList;

/**
 * [111] 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class MinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new MinDepth().minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int minDepth = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            minDepth++;
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode first = queue.removeFirst();
                if (first.left == null && first.right == null) {
                    return minDepth;
                }
                if (first.left != null) {
                    queue.addLast(first.left);
                }
                if (first.right != null) {
                    queue.addLast(first.right);
                }
            }
        }
        return minDepth;
    }
}