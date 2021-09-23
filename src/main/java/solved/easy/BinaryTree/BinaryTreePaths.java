package solved.easy.BinaryTree;

import java.util.*;

/**
 * [257] 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println(new BinaryTreePaths().binaryTreePaths(root).toString());
    }

    /**
     * 只能用前序遍历/后序遍历
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        path.addLast(root.val);

        backTracking(root, path, res);

        return res;
    }

    private void backTracking(TreeNode root, LinkedList<Integer> path, List<String> res) {
        if (root.left == null & root.right == null) {
            StringBuilder builder = new StringBuilder();
            Iterator<Integer> iterator = path.iterator();
            while (iterator.hasNext()) {
                builder.append(iterator.next());
                if (iterator.hasNext())
                    builder.append("->");
            }
            res.add(builder.toString());
            return;
        }

        if (root.left != null) {
            path.addLast(root.left.val);
            backTracking(root.left, path, res);
            path.removeLast();
        }
        if (root.right != null) {
            path.addLast(root.right.val);
            backTracking(root.right, path, res);
            path.removeLast();
        }
    }
}
