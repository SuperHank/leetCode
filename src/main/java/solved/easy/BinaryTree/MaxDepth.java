package solved.easy.BinaryTree;

import java.util.LinkedList;

/**
 * [104] 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new MaxDepth().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = queue.removeFirst();
                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }
            }
        }
        return depth;
    }
}