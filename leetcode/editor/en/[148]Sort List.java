148
        Sort List
        2022-12-16 16:24:22
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
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        Collections.sort(list);
        ListNode dummy = new ListNode();
        node = dummy;
        for (int num : list) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
