package solved.easy.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * [145] 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new PostorderTraversal().postorderTraversal_iter_comm(root1));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(new PostorderTraversal().postorderTraversal_iter_comm(root2));
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(new PostorderTraversal().postorderTraversal_iter_comm(root3));
    }

    /**
     * 递归法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    /**
     * 迭代法
     */
    public List<Integer> postorderTraversal_iter(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();

            result.add(current.val);
            if (current.left != null) {
                stack.addLast(current.left);
            }
            if (current.right != null) {
                stack.addLast(current.right);
            }
        }
        Collections.reverse(result);
        return result;
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

                stack.addLast(current);
                stack.addLast(null);

                if (current.right != null) {
                    stack.addLast(current.right);
                }
                if (current.left != null) {
                    stack.addLast(current.left);
                }
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
