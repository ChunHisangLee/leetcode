//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public String gameResult(ListNode head) {
        int oddScore = 0;
        int evenScore = 0;
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val > current.next.val) {
                evenScore++;
            } else if (current.val < current.next.val) {
                oddScore++;
            }

            current = current.next.next;
        }

        if (oddScore > evenScore) {
            return "Odd";
        } else if (oddScore < evenScore) {
            return "Even";
        } else {
            return "Tie";
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
