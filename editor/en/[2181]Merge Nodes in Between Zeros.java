
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode currSum = dummy;
        ListNode curr = head.next;
        int sum = 0;

        while (curr != null) {
            if (curr.val == 0) {
                currSum.next = new ListNode(sum);
                currSum = currSum.next;
                sum = 0;
            } else {
                sum += curr.val;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
