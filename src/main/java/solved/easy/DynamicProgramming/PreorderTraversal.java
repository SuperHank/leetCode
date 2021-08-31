package solved.easy.DynamicProgramming;

import java.util.ArrayList;
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