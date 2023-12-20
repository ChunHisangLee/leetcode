
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        int width = count / k;
        int reminder = count % k;
        curr = head;
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ListNode headNode = null;
            ListNode tailNode = null;
            for (int j = 0; j < width + (i < reminder ? 1 : 0); j++) {
                if (headNode == null) {
                    headNode = tailNode = curr;
                } else {
                    tailNode.next = curr;
                    tailNode = tailNode.next;
                }
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (tailNode != null) {
                tailNode.next = null;
            }
            list.add(headNode);
        }
        return list.toArray(new ListNode[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
