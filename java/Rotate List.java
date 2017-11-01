/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        int len = 1;
        ListNode p = head;
        while (p.next != null) {//这个地方不用 p!= null，是为了得到尾节点
            len++;
            p = p.next;
        }
        p.next = head;//形成环

        k = len - k % len;

        for (int i = 1; i <= k; i++) {
            p = p.next;
        }

        head = p.next;
        p.next = null;

        return head;
    }
}
