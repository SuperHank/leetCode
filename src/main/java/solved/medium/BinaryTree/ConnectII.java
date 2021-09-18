package solved.medium.BinaryTree;


import java.util.LinkedList;

/**
 * [117] 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-ConnectNode-ii/
 */
public class ConnectII {

    public static void main(String[] args) {
        ConnectNode root = new ConnectNode(1, new ConnectNode(2, new ConnectNode(4), new ConnectNode(5), null), new ConnectNode(3, null, new ConnectNode(7), null), null);
        System.out.println(new ConnectII().connect(root));
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