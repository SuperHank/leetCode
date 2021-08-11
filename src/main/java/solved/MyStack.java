package solved;

import java.util.LinkedList;

/**
 * [225] 用栈实现队列
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class MyStack {
    /**
     * 使用queue作为队列
     */
    private LinkedList queue;

    public MyStack() {
        if (queue == null) {
            queue = new LinkedList<Integer>();
        } else {
            queue.clear();
        }
    }

    public void push(int x) {
        this.queue.addLast(x);
    }

    public int pop() {
        if (queue.size() > 0) {
            return (int) queue.remove(queue.size() - 1);
        }
        return -1;
    }

    public int top() {
        if (queue.size() > 0)
            return (int) queue.getLast();
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
