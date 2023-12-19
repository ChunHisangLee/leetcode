
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }

        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
