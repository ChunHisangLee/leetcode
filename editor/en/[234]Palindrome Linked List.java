//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode end = reverseList(middle.next);
        return checkPalindrome(head, end);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    private boolean checkPalindrome(ListNode head, ListNode end) {
        ListNode p1 = head;
        ListNode p2 = end;
        boolean isPalindrome = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindrome = false;
                break;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return isPalindrome;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
