//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int val1 = curr.val;
            int val2 = curr.next.val;
            int gcdValue = gcd(val1, val2);
            ListNode gcdNode = new ListNode(gcdValue);
            gcdNode.next = curr.next;
            curr.next = gcdNode;
            curr = gcdNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
