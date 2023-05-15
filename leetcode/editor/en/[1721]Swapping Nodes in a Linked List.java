
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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;
        ListNode left = head;
        ListNode right = head;
        int count = 1;
        while (count < k) {
            left = left.next;
            temp = temp.next;
            count++;
        }
        while (temp.next != null) {
            temp = temp.next;
            right = right.next;
        }
        int value = right.val;
        right.val = left.val;
        left.val = value;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
