
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverseList(head);
        ListNode current = reversed;
        int carry = 0;
        ListNode prev = null;

        while (current != null) {
            int sum = current.val * 2 + carry;
            current.val = sum % 10;
            carry = sum / 10;
            prev = current;
            current = current.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }

        return reverseList(reversed);
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
