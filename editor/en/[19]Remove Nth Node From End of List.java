// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    slow.next = slow.next.next;
    return dummy.next;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
