package solved.easy.BinaryTree;

import java.util.LinkedList;

/**
 * [226] 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(new InvertTree().invertTree(root));
    }

    public TreeNode invertTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.addLast(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode current = queue.removeFirst();
                TreeNode tmp = current.left;
                current.left = current.right;
                current.right = tmp;

                if (current.left != null)
                    queue.addLast(current.left);
                if (current.right != null)
                    queue.addLast(current.right);
            }
        }
        return root;
    }
}