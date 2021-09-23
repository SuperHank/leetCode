package solved.medium.BinaryTree;

import java.util.LinkedList;

/**
 * [513] 找树左下角的值
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        System.out.println(new FindBottomLeftValue().findBottomLeftValue(root));
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int result = 0;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                if (i == 0) {
                    result = queue.getFirst().val;
                }
                TreeNode current = queue.removeFirst();
                if (current.left != null) {
                    queue.addLast(current.left);
                }
                if (current.right != null) {
                    queue.addLast(current.right);
                }
            }
        }
        return result;
    }
}
