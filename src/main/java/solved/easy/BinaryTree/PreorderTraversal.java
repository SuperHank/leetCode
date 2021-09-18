package solved.easy.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [144] 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new PreorderTraversal().preorderTraversal(root1));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(new PreorderTraversal().preorderTraversal(root2));
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(new PreorderTraversal().preorderTraversal(root3));
    }

    /**
     * 递归法
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    /**
     * 迭代法
     */
    public List<Integer> preorderTraversal_iter(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode last = stack.removeLast();

            res.add(last.val);

            if (last.right != null) {
                stack.addLast(last.right);
            }
            if (last.left != null) {
                stack.addLast(last.left);
            }
        }

        return res;
    }

    /**
     * 通用迭代法
     */
    public List<Integer> postorderTraversal_iter_comm(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.addLast(root);
        }
        while (!stack.isEmpty()) {
            TreeNode current = stack.getLast();
            if (current != null) {
                current = stack.removeLast();


                if (current.right != null) {
                    stack.addLast(current.right);
                }
                if (current.left != null) {
                    stack.addLast(current.left);
                }
                stack.addLast(current);
                stack.addLast(null);
            } else {
                stack.removeLast();

                if (!stack.isEmpty()) {
                    current = stack.removeLast();
                    res.add(current.val);
                }
            }
        }

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