2
        Add Two Numbers
        2022-11-26 11:34:33
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = sumNodes(l1, l2, carry);
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            curr = curr.next;
            l1 = moveToNext(l1);
            l2 = moveToNext(l2);
        }

        return dummy.next;
    }

    private int sumNodes(ListNode node1, ListNode node2, int carry) {
        int sum = carry;
        if (node1 != null) {
            sum += node1.val;
        }
        if (node2 != null) {
            sum += node2.val;
        }
        return sum;
    }

    private ListNode moveToNext(ListNode node) {
        return node != null ? node.next : null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
