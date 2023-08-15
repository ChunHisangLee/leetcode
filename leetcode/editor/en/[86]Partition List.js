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
 * @param {number} x
 * @return {ListNode}
 */
var partition = function (head, x) {
    let dummy1 = new ListNode();
    let dummy2 = new ListNode();
    let curr1 = dummy1;
    let curr2 = dummy2;
    let curr = head;
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
};
//leetcode submit region end(Prohibit modification and deletion)
