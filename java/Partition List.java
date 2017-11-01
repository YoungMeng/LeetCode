/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode lessthan = new ListNode(0);
        ListNode greaterthan = new ListNode(0);

        ListNode less_head = lessthan;
        ListNode greater_head = greaterthan;

        while (head != null) {
            if (head.val < x) {
                lessthan.next = head;
                lessthan = head;
            } else {
                greaterthan.next = head;
                greaterthan = head;
            }
            head = head.next;
        }

        lessthan.next = greater_head.next;
        greaterthan.next = null;

        return less_head.next;
    }
}
