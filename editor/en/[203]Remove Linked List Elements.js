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
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function (head, val) {
    const dummy = new ListNode(0, head);
    let prev = dummy;
    let curr = head;

    while (curr != null) {
        if (curr.val === val) {
            prev.next = curr.next;
        } else {
            prev = curr;
        }
        curr = curr.next;
    }

    return dummy.next;
};
//leetcode submit region end(Prohibit modification and deletion)
