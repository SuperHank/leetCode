package solved.medium;

/**
 * [19] 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(head1, 2));

        ListNode head2 = new ListNode(1, null);
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(head2, 1));

        ListNode head3 = new ListNode(1, new ListNode(2, null));
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(head3, 1));

        ListNode head4 = new ListNode(1, new ListNode(2, null));
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(head4, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode toDelete = head;

        for (int i = 0; i < n; i++) {
            if (current != null) {
                current = current.next;
            }
        }

        if (current == null) {
            return head.next;
        }

        while (current.next != null) {
            current = current.next;
            toDelete = toDelete.next;
        }

        toDelete.next = toDelete.next.next;

        return head;
    }
}