2130
        Maximum Twin Sum of a Linked List
        2022-11-29 14:29:46
//leetcode submit region begin(Prohibit modification and deletion)

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
    public int pairSum(ListNode head) {
        if (head.next.next == null)
            return head.val + head.next.val;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            ;
        }
        ListNode tail = reverseList(slow);
        int ans = 0;
        while (tail != null) {
            ans = Math.max(ans, head.val + tail.val);
            head = head.next;
            tail = tail.next;
        }
        return ans;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
