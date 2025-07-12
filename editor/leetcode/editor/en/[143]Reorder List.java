// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode second = reverseList(slow);
    ListNode first = head;

    while (second.next != null) {
      ListNode temp1 = first.next;
      ListNode temp2 = second.next;

      first.next = second;
      first = temp1;

      second.next = first;
      second = temp2;
    }
  }

  private ListNode reverseList(ListNode curr) {
    ListNode prev = null;

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
