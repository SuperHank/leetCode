package solved.easy.DynamicProgramming;

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

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left.val != right.val) {
            return false;
        }


        return test(left, right);
    }

    public boolean test(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }
        TreeNode leftOfLeft = left.left;
        TreeNode rightOfLeft = left.right;
        TreeNode leftOfRight = right.left;
        TreeNode rightOfRight = right.right;

        boolean leftResult;

        if (leftOfLeft == null && rightOfRight == null) {
            leftResult = true;
        } else if (leftOfLeft == null || rightOfRight == null) {
            leftResult = false;
        } else {
            leftResult = leftOfLeft.val == rightOfRight.val;
        }

        boolean rightResult;
        if (rightOfLeft == null && leftOfRight == null) {
            rightResult = true;
        } else if (rightOfLeft == null || leftOfRight == null) {
            rightResult = false;
        } else {
            rightResult = rightOfLeft.val == leftOfRight.val;
        }

        if (!(rightResult && leftResult)) {
            return false;
        }
        return test(left.left, right.right) && test(left.right, right.left);
    }


}