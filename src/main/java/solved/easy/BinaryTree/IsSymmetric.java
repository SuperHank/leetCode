package solved.easy.BinaryTree;

/**
 * [100] 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(new IsSymmetric().isSymmetric(root1));
        TreeNode root3 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(new IsSymmetric().isSymmetric(root3));
    }

    /**
     * 递归法
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }


    public boolean isSymmetric_iter(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }
}