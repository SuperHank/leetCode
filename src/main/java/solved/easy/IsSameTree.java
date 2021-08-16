package solved.easy;


/**
 * [100] 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null);
        TreeNode root3 = new TreeNode(1, null, new TreeNode(2));
        TreeNode root4 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(new IsSameTree().isSameTree(root1, root2));
        System.out.println(new IsSameTree().isSameTree(root3, root4));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        } else if (q.val != p.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}