package solved;

import java.util.ArrayList;

public class MinStack {
    private ArrayList<Integer> list;

    public MinStack() {
        list = new ArrayList();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (Integer integer : list) {
            min = Integer.min(integer, min);
        }
        return min;
    }
}
