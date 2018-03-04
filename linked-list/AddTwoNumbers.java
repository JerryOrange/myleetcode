/**
 * 002. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Created by Jiacheng on 2018/3/4.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solutionNode = new ListNode(0), p = l1, q = l2, curr = solutionNode;
        int carry = 0; //进位
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return solutionNode.next;
    }

    public static void main(String[] args) {
        /*Example
        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8
        Explanation: 342 + 465 = 807.*/
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        ListNode solution = new AddTwoNumbers().addTwoNumbers(listNode1, listNode2);
        while (solution != null) {
            System.out.print(solution.val);
            solution = solution.next;
        }
    }
}
