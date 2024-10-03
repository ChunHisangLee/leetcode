
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        while (curr != null) {
            curr = curr.next;
            count++;
        }

        ListNode[] result = new ListNode[k];
        int width = count / k;
        int reminder = count % k;
        curr = head;

        for (int i = 0; i < k; i++) {
            result[i] = curr;
            int currSize = width + ((i < reminder) ? 1 : 0);

            for (int j = 0; j < currSize - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
