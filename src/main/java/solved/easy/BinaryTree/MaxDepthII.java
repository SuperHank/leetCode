package solved.easy.BinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [559] N叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaxDepthII {
    public static void main(String[] args) {

        Node root = new Node(1, Arrays.asList(new Node(3, Arrays.asList(new Node(5), new Node(6))), new Node(2), new Node(4)));
        System.out.println(new MaxDepthII().maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        int maxDepth = 0;
        while (!queue.isEmpty()) {
            maxDepth++;

            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                Node node = queue.removeFirst();
                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.addLast(child);
                    }
                }
            }
        }
        return maxDepth;
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