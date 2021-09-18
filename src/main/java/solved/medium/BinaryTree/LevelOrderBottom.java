package solved.medium.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * [107] 二叉树的层序遍历 II
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelOrderBottom {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new LevelOrderBottom().levelOrderBottom(root));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = queue.removeFirst();
                list.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}