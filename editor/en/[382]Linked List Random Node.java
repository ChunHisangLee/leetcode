/**
 * <p>Given a singly linked list, return a random node's value from the linked list. Each node must have the <strong>same probability</strong> of being chosen.</p>
 *
 * <p>Implement the <code>Solution</code> class:</p>
 *
 * <ul>
 * <li><code>Solution(ListNode head)</code> Initializes the object with the head of the singly-linked list <code>head</code>.</li>
 * <li><code>int getRandom()</code> Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/16/getrand-linked-list.jpg" style="width: 302px; height: 62px;" />
 * <pre>
 * <strong>Input</strong>
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * <strong>Output</strong>
 * [null, 1, 3, 2, 2, 3]
 * </pre>
 *
 * <strong>Explanation</strong>
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // return 1
 * solution.getRandom(); // return 3
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 2
 * solution.getRandom(); // return 3
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the linked list will be in the range <code>[1, 10<sup>4</sup>]</code>.</li>
 * <li><code>-10<sup>4</sup> &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
 * <li>At most <code>10<sup>4</sup></code> calls will be made to <code>getRandom</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong></p>
 *
 * <ul>
 * <li>What if the linked list is extremely large and its length is unknown to you?</li>
 * <li>Could you solve this efficiently without using extra space?</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Linked List</li><li>Math</li><li>Reservoir Sampling</li><li>Randomized</li></div></div><br><div><li>👍 2036</li><li>👎 485</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    public Solution(ListNode head) {
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
    }

    public int getRandom() {
        return list.get((int) (list.size() * Math.random()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)
