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
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
var reverseBetween = function (head, left, right) {
    const dummy = new ListNode(0, head);
    let prev = dummy;

    for (let i = 1; i < left; i++) {
        prev = prev.next;
    }

    let curr = prev.next;

    for (let i = 0; i < right - left; i++) {
        let temp = curr.next;
        curr.next = temp.next;
        temp.next = prev.next;
        prev.next = temp;
    }

    return dummy.next;
};
//leetcode submit region end(Prohibit modification and deletion)
