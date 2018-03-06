/**
 * 083. Remove Duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Created by Jiacheng on 2018/3/6.
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode solution = new ListNode(0), point = solution;
        int pre = 0, n = 0;
        while (head != null) {
            if (n == 0) {
                point.next = new ListNode(head.val);
                point = point.next;
            }
            if (n != 0) {
                if (pre != head.val) {
                    point.next = new ListNode(head.val);
                    point = point.next;
                }
            }
            pre = head.val;
            n++;
            head = head.next;
        }
        return solution.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode solution = new RemoveDuplicatesFromSortedList().deleteDuplicates(listNode);
        while (solution != null) {
            System.out.print(solution.val);
            solution = solution.next;
        }
    }
}
