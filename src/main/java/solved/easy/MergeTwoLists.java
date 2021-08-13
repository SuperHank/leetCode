package solved.easy;

/**
 * [21] 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        new MergeTwoLists().mergeTwoLists(list1, list2);

        ListNode list3 = new ListNode(2);
        ListNode list4 = new ListNode(1, new ListNode(3));
        new MergeTwoLists().mergeTwoLists(list3, list4);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        while (l2 != null) {
            ListNode y = l2;
            ListNode yNext = l2.next;
            y.next = null;
            l2 = yNext;

            int yValue = y.val;

            if (l1.val > yValue) {
                y.next = l1;
                l1 = y;
                continue;
            }
            ListNode x = l1;
            while (x != null) {
                ListNode xNext = x.next;

                if (xNext == null) {
                    if (x.val <= yValue) {
                        x.next = y;
                        break;
                    }
                } else {
                    if (x.val <= yValue && yValue < xNext.val) {
                        x.next = y;
                        y.next = xNext;
                        break;
                    }
                }
                x = x.next;
            }
        }
        return l1;
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