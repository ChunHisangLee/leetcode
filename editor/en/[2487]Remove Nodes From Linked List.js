//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var removeNodes = function (head) {
    if (head === null) {
        return null;
    }

    head.next = removeNodes(head.next);

    if (head.next !== null && head.val < head.next.val) {
        return head.next;
    }

    return head;
};
//leetcode submit region end(Prohibit modification and deletion)
