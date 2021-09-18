package solved.easy.DynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [94] 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new InorderTraversal().inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 迭代法
     */
    public List<Integer> inorderTraversal_iter(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.addLast(current);
                current = current.left;
            } else {
                current = stack.removeLast();
                res.add(current.val);
                current = current.right;
            }
        }

        return res;
    }

    /**
     * 通用迭代法
     */
    public List<Integer> inorderTraversal_iter_comm(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
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
                if (stack.isEmpty()) {
                    break;
                }
                current = stack.removeLast();
                res.add(current.val);
            }
        }

        return res;
    }
}