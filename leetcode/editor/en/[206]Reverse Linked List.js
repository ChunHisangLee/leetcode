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
var reverseList = function (head) {
    if (head === null) {
        return null;
    }

    let dummy = new ListNode();
    dummy.next = head;
    prev = dummy;
    curr = head;

    while (curr.next !== null) {
        temp = curr.next;
        curr.next = temp.next;
        temp.next = prev.next;
        prev.next = temp;
    }

    return dummy.next;
};
//leetcode submit region end(Prohibit modification and deletion)
