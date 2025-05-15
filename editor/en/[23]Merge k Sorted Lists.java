// leetcode submit region begin(Prohibit modification and deletion)

class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null) {
      return null;
    }

    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

    for (ListNode list : lists) {
      if (list != null) {
        minHeap.offer(list);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.poll();

      curr.next = node;
      curr = curr.next;

      if (node.next != null) {
        minHeap.offer(node.next);
      }
    }

    return dummy.next;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
