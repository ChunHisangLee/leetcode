
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        tail.next = head;
        ListNode nTail = head;
        for (int i = 0; i < n - (k % n) - 1; i++) {
            nTail = nTail.next;
        }
        ListNode nHead = nTail.next;
        nTail.next = null;
        return nHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
