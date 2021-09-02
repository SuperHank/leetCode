package solved.medium.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * [113] 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode head1 = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        System.out.println(new PathSum().pathSum(head1, 22));
        TreeNode head2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(new PathSum().pathSum(head2, 5));
        TreeNode head3 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(new PathSum().pathSum(head3, 0));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();

        backTracking(root, targetSum, 0, root, path, res);

        return res;
    }

    private void backTracking(TreeNode root, int targetSum, int currentSum, TreeNode currentNode, LinkedList<Integer> path, List<List<Integer>> res) {
        if (currentNode == null) {
            return;
        }
        currentSum += currentNode.val;
        path.addLast(currentNode.val);

        if (currentNode.left == null && currentNode.right == null) {
            if (currentSum == targetSum) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (currentNode.left != null) {
            backTracking(root, targetSum, currentSum, currentNode.left, path, res);
            path.removeLast();
        }
        if (currentNode.right != null) {
            backTracking(root, targetSum, currentSum, currentNode.right, path, res);
            path.removeLast();
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}