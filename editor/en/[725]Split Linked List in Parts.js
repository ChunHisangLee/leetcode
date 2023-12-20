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
 * @param {number} k
 * @return {ListNode[]}
 */
var splitListToParts = function (head, k) {
    let curr = head;
    let count = 0;
    while (curr) {
        curr = curr.next;
        count++;
    }
    let width = Math.floor(count / k);
    let reminder = count % k;
    curr = head;
    let list = new Array();
    for (let i = 0; i < k; i++) {
        let headNode = null;
        let tailNode = null;
        for (let j = 0; j < width + (i < reminder ? 1 : 0); j++) {
            if (headNode === null) {
                headNode = tailNode = curr;
            } else {
                tailNode.next = curr;
                tailNode = tailNode.next;
            }
            if (curr !== null) {
                curr = curr.next;
            }
        }
        if (tailNode !== null) {
            tailNode.next = null;
        }
        list[i] = headNode;
    }
    return list;
};
//leetcode submit region end(Prohibit modification and deletion)
