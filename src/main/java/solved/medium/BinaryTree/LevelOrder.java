package solved.medium.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [429] N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class LevelOrder {

    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
        System.out.println(new LevelOrder().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();

        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                Node first = queue.removeFirst();
                list.add(first.val);

                if (first.children != null && first.children.size() > 0) {
                    for (Node child : first.children) {
                        queue.addLast(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};