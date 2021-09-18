package solved.easy.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [102] 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new LevelOrder().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode firstNode = queue.removeFirst();
                list.add(firstNode.val);
                if (firstNode.left != null) {
                    queue.addLast(firstNode.left);
                }
                if (firstNode.right != null) {
                    queue.addLast(firstNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}