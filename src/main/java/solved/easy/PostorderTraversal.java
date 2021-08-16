package solved.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * [145] 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(new PostorderTraversal().postorderTraversal(root1));
        TreeNode root2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(new PostorderTraversal().postorderTraversal(root2));
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(new PostorderTraversal().postorderTraversal(root3));
    }

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
}
