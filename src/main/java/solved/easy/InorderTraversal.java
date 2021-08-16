package solved.easy;

import java.util.ArrayList;
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
}
