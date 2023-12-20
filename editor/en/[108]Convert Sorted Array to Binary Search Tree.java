/**
 * <p>Given an integer array <code>nums</code> where the elements are sorted in <strong>ascending order</strong>, convert <em>it to a </em><span data-keyword="height-balanced"><strong><em>height-balanced</em></strong></span> <em>binary search tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg" style="width: 302px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> nums = [-10,-3,0,5,9]
 * <strong>Output:</strong> [0,-3,9,-10,null,5]
 * <strong>Explanation:</strong> [0,-10,5,null,-3,null,9] is also accepted:
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg" style="width: 302px; height: 222px;" />
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/02/18/btree.jpg" style="width: 342px; height: 142px;" />
 * <pre>
 * <strong>Input:</strong> nums = [1,3]
 * <strong>Output:</strong> [3,1]
 * <strong>Explanation:</strong> [1,null,3] and [3,1] are both height-balanced BSTs.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
 * <li><code>nums</code> is sorted in a <strong>strictly increasing</strong> order.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Divide and Conquer</li><li>Tree</li><li>Binary Search Tree</li><li>Binary Tree</li></div></div><br><div><li>👍 9471</li><li>👎 474</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return toBST(0, nums.length - 1);
    }

    public TreeNode toBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = toBST(left, mid - 1);
        node.right = toBST(mid + 1, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
