2130
        Maximum Twin Sum of a Linked List
        2022-11-29 14:29:46
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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int n = list.size();
        int max = 0;
        for (int i = 0; i <= n / 2; i++) {
            max = Math.max(max, list.get(i) + list.get(n - 1 - i));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int pairSum(ListNode head) {
        ListNode mid = middle(head);
        ListNode second = reverse(mid);
        ListNode first = head;
        return twinSum(first, second);
    }

    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
    }

    public int twinSum(ListNode first, ListNode second) {
        int res = Integer.MIN_VALUE;
        while (first != null && second != null) {
            res = Math.max(res, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        return res;
    }
}
 */