
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else {
                curr2.next = curr;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public ListNode partition(ListNode head, int x) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                left.add(curr.val);
            } else {
                right.add(curr.val);
            }
            curr = curr.next;
        }
        left.addAll(right);
        int index = 0;
        curr = head;
        while (curr != null) {
            curr.val = left.get(index++);
            curr = curr.next;
        }
        return head;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else {
                curr2.next = curr;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
 */