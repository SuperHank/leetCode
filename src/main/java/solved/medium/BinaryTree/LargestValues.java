package solved.medium.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [515] 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class LargestValues {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(new LargestValues().largestValues(root));
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            Integer max = Integer.MIN_VALUE;
            for (int i = 0; i < currentSize; i++) {
                TreeNode firstNode = queue.removeFirst();
                if (max < firstNode.val) {
                    max = firstNode.val;
                }
                if (firstNode.left != null) {
                    queue.addLast(firstNode.left);
                }
                if (firstNode.right != null) {
                    queue.addLast(firstNode.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}