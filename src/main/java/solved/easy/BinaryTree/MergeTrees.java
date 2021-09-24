package solved.easy.BinaryTree;

/**
 * [617] 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTrees {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode right = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode result = new MergeTrees().mergeTrees(left, right);
        System.out.println(result);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
