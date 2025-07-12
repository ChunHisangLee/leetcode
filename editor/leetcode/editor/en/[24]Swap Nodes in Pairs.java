// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode first = head;

    while (first != null && first.next != null) {
      ListNode second = first.next;

      prev.next = second;
      first.next = second.next;
      second.next = first;

      prev = first;
      first = first.next;
    }

    return dummy.next;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
