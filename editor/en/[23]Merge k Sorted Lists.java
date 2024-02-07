//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
