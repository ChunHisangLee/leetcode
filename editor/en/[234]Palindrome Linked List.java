// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    ListNode secondHalf = reverseList(slow);
    ListNode firstHalf = head;

    while (secondHalf != null) {
      if (firstHalf.val != secondHalf.val) {
        return false;
      }

      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }

    return true;
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
