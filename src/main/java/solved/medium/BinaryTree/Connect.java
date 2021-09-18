package solved.medium.BinaryTree;

import java.util.LinkedList;

/**
 * [116] 填充每个节点的下一个右侧节点指针
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Connect {

    public static void main(String[] args) {
        ConnectNode root = new ConnectNode(1, new ConnectNode(2, new ConnectNode(4), new ConnectNode(5), null), new ConnectNode(3, new ConnectNode(6), new ConnectNode(7), null), null);
        System.out.println(new Connect().connect(root));
    }

    public ConnectNode connect(ConnectNode root) {
        LinkedList<ConnectNode> queue = new LinkedList<>();

        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int currentSize = queue.size();

            for (int i = 0; i < currentSize; i++) {
                ConnectNode first = queue.removeFirst();
                if (i == currentSize - 1) {
                    first.next = null;
                } else {
                    first.next = queue.getFirst();
                }
                if (first.left != null)
                    queue.addLast(first.left);
                if (first.right != null)
                    queue.addLast(first.right);
            }
        }
        return root;
    }
}

class ConnectNode {
    public int val;
    public ConnectNode left;
    public ConnectNode right;
    public ConnectNode next;

    public ConnectNode() {
    }

    public ConnectNode(int _val) {
        val = _val;
    }

    public ConnectNode(int _val, ConnectNode _left, ConnectNode _right, ConnectNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};