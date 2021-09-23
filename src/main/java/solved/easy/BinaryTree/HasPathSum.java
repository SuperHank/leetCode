package solved.easy.BinaryTree;

/**
 * [112] 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        System.out.println(new HasPathSum().hasPathSum(root1, 22));
        TreeNode root2 = new TreeNode(1, new TreeNode(-2, new TreeNode(1), new TreeNode(3)), new TreeNode(-3, new TreeNode(-2), null));
        System.out.println(new HasPathSum().hasPathSum(root2, 3));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backTracking(root, targetSum);
    }

    private boolean backTracking(TreeNode current, int targetSum) {
        if (current == null) {
            return false;
        }
        if (current.left == null && current.right == null) {
            return current.val == targetSum;
        }
        return backTracking(current.left, targetSum - current.val) || backTracking(current.right, targetSum - current.val);
    }
}
