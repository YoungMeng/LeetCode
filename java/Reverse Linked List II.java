/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre_m = null;
        ListNode pre = dummy;

        for (int i = 1; i <= n; i++) {
            if (i == m) pre_m = pre;

            if (i > m && i <= n) {
                pre.next = head.next;
                head.next = pre_m.next;
                pre_m.next = head;
                head = pre;
            }

            pre = head;
            head = head.next;
        }

        return dummy.next;
    }
}
