package solved.medium.DynamicProgramming;

/**
 * [2] 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
//        System.out.println(new AddTwoNumbers().addTwoNumbers(
//                new ListNode(2, new ListNode(4, new ListNode(3))),
//                new ListNode(5, new ListNode(6, new ListNode(4)))));
//        System.out.println(new AddTwoNumbers().addTwoNumbers(
//                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
//                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))));

        System.out.println(new AddTwoNumbers().addTwoNumbers(
                new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))))))),
                new ListNode(9)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int sup = 0;
        while (l1 != null || l2 != null) {
            int tmpResult = 0;
            if (l1 != null) {
                tmpResult += l1.val;
            }
            if (l2 != null) {
                tmpResult += l2.val;
            }

            tmpResult += sup;

            if (tmpResult >= 10) {
                sup = tmpResult / 10;
            } else {
                sup = 0;
            }
            tmpResult = tmpResult % 10;

            if (head == null) {
                head = new ListNode(tmpResult, null);
                tail = head;
            } else {
                tail.next = new ListNode(tmpResult, null);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (sup != 0) {
            tail.next = new ListNode(sup, null);
        }
        return head;
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
