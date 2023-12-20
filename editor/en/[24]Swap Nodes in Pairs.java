24
        Swap Nodes in Pairs
        2022-11-29 13:40:42
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Iterative Approach

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = head.next;
        ListNode prev = null;
        while (head != null && head.next != null) {
            if (prev != null)
                prev.next = head.next;
            prev = head;
            ListNode nextNode = head.next.next;
            head.next.next = head;
            head.next = nextNode;
            head = nextNode;
        }
        return dummy;
    }
}
 */