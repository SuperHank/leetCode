package attempted;

/**
 * [106] 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class BuildTree {

    public static void main(String[] args) {
        System.out.println(new BuildTree().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return null;
    }
}
