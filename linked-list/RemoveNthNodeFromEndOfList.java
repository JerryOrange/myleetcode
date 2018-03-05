/**
 * 019. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * Created by Jiacheng on 2018/3/4.
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * Hints: Maintain two pointers and update one with a delay of n steps.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        /*Example
        Given linked list: 1->2->3->4->5, and n = 2.
        After removing the second node from the end, the linked list becomes 1->2->3->5.*/
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        ListNode solution = new RemoveNthNodeFromEndOfList().removeNthFromEnd(listNode1, 2);
        while (solution != null) {
            System.out.print(solution.val);
            solution = solution.next;
        }
    }
}

