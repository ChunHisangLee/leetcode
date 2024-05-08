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
var doubleIt = function (head) {
    const reversedList = function (node) {
        let prev = null;
        let current = node;
        let next = null;

        while (current !== null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    let reversed = reversedList(head);
    let current = reversed;
    let prev = null;
    let carry = 0;

    while (current !== null) {
        let sum = current.val * 2 + carry;
        current.val = sum % 10;
        carry = Math.floor(sum / 10);
        prev = current;
        current = current.next;
    }

    if (carry > 0) {
        prev.next = new ListNode(carry);
    }

    return reversedList(reversed);
};
//leetcode submit region end(Prohibit modification and deletion)
