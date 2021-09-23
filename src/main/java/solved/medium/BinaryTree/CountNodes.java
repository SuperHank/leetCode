package solved.medium.BinaryTree;

import java.util.LinkedList;

/**
 * [222] 完全二叉树的节点个数
 */
public class CountNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(new CountNodes().countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(root);

        int count = 0;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode current = queue.removeFirst();
                count++;
                if (current.left != null)
                    queue.addLast(current.left);
                if (current.right != null)
                    queue.addLast(current.right);
            }
        }

        return count;
    }
}