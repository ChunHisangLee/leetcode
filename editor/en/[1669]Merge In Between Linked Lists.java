
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode prev = dummy;

        for (int i = 0; i < a; i++) {
            prev = prev.next;
        }

        ListNode end = prev;

        for (int i = a; i <= b; i++) {
            end = end.next;
        }

        prev.next = list2;

        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = end.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
