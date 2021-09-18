package solved.medium.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [637] 二叉树的层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevels {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(new AverageOfLevels().averageOfLevels(root));
        TreeNode root2 = new TreeNode(2147483647, new TreeNode(2147483647), new TreeNode(2147483647));
        System.out.println(new AverageOfLevels().averageOfLevels(root2));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode currentNode = queue.removeFirst();
                list.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }
            }
            long sum = list.stream().mapToLong(Integer::longValue).sum();

            res.add(new Double((double) sum / list.size()).doubleValue());
        }
        return res;
    }
}