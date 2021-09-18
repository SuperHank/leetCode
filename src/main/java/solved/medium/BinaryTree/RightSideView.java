package solved.medium.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [199] 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 */
public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        System.out.println(new RightSideView().rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.addLast(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode first = queue.removeFirst();
                if (first.left != null) {
                    queue.addLast(first.left);
                }
                if (first.right != null) {
                    queue.addLast(first.right);
                }
                if (i == currentSize - 1) {
                    res.add(first.val);
                }
            }
        }

        return res;
    }
}