package attempted;

/**
 * [23] 合并K个升序链表
 */
public class MergeKLists {

    public static void main(String[] args) {
        new MergeKLists().mergeKLists(null);
    }

    public ListNode mergeKLists(ListNode[] lists) {


        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}