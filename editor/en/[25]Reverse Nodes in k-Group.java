// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode groupPrev = dummy;

    while (true) {
      ListNode kth = groupPrev;
      for (int i = 0; i < k && kth != null; i++) {
        kth = kth.next;
      }
      if (kth == null) {
        break;
      }

      ListNode groupNext = kth.next;

      ListNode prev = groupNext;
      ListNode curr = groupPrev.next;
      while (curr != groupNext) {
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }

      ListNode oldHead = groupPrev.next;
      groupPrev.next = prev;
      groupPrev = oldHead;
    }

    return dummy.next;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
