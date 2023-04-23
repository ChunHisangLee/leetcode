/**
 * <p>You are given the <code>root</code> of a binary tree.</p>
 *
 * <p>A ZigZag path for a binary tree is defined as follow:</p>
 *
 * <ul>
 * <li>Choose <strong>any </strong>node in the binary tree and a direction (right or left).</li>
 * <li>If the current direction is right, move to the right child of the current node; otherwise, move to the left child.</li>
 * <li>Change the direction from right to left or from left to right.</li>
 * <li>Repeat the second and third steps until you can't move in the tree.</li>
 * </ul>
 *
 * <p>Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).</p>
 *
 * <p>Return <em>the longest <strong>ZigZag</strong> path contained in that tree</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/01/22/sample_1_1702.png" style="width: 221px; height: 383px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Longest ZigZag path in blue nodes (right -&gt; left -&gt; right).
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/01/22/sample_2_1702.png" style="width: 157px; height: 329px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,1,1,null,1,null,null,1,1,null,1]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> Longest ZigZag path in blue nodes (left -&gt; right -&gt; left -&gt; right).
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1]
 * <strong>Output:</strong> 0
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 5 * 10<sup>4</sup>]</code>.</li>
 * <li><code>1 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Dynamic Programming</li><li>Tree</li><li>Depth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 1500</li><li>👎 26</li></div>
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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return max;
    }

    public void dfs(TreeNode node, boolean goLeft, int level) {
        if (node == null) {
            return;
        }
        if (level > max) {
            max = level;
        }
        if (goLeft) {
            dfs(node.left, true, 1);
            dfs(node.right, false, level + 1);
        } else {
            dfs(node.left, true, level + 1);
            dfs(node.right, false, 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
