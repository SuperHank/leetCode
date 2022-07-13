package attempted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [501] 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 */
public class FindMode {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        System.out.println(Arrays.toString(new FindMode().findMode(root1)));
        TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println(Arrays.toString(new FindMode().findMode(root2)));
    }

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.getLast();
            if (current != null) {
                current = stack.removeLast();
                if (current.right != null) {
                    stack.addLast(current.right);
                }
                stack.addLast(current);
                stack.addLast(null);

                if (current.left != null) {
                    stack.addLast(current.left);
                }

            } else {
                stack.removeLast();
                if (!stack.isEmpty()) {
                    current = stack.removeLast();
                    res.add(current.val);
                }
            }
        }

        int maxSize = 1;
        int tmpSize = 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) == res.get(i + 1)) {
                tmpSize++;
                if (maxSize < tmpSize) {
                    result.clear();
                    result.add(res.get(i));
                    maxSize = tmpSize;
                }
            } else {
                if (tmpSize == 1) {
                    result.add(res.get(i));
                } else {
                    tmpSize = 1;
                    result.clear();
                    result.add(res.get(i));
                    if (i == res.size() - 2) {
                        res.add(res.get(i + 1));
                    }
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}