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

    ListNode secondHalf = reverseList(slow);
    ListNode firstHalf = head;

    while (secondHalf.next != null) {
      ListNode temp1 = firstHalf.next;
      ListNode temp2 = secondHalf.next;

      firstHalf.next = secondHalf;
      firstHalf = temp1;

      secondHalf.next = firstHalf;
      secondHalf = temp2;
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
