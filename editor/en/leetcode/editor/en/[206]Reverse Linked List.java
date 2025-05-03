// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
