/**
 * <p>Given the <code>root</code> of a binary tree, collect a tree's nodes as if you were doing this:</p>
 *
 * <ul>
 * <li>Collect all the leaf nodes.</li>
 * <li>Remove all the leaf&nbsp;nodes.</li>
 * <li>Repeat until the tree is empty.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/03/16/remleaves-tree.jpg" style="width: 500px; height: 215px;" />
 * <pre>
 * <strong>Input:</strong> root = [1,2,3,4,5]
 * <strong>Output:</strong> [[4,5,3],[2],[1]]
 * Explanation:
 * [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> root = [1]
 * <strong>Output:</strong> [[1]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[1, 100]</code>.</li>
 * <li><code>-100 &lt;= Node.val &lt;= 100</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Tree</li><li>Depth-First Search</li><li>Binary Tree</li></div></div><br><div><li>👍 3053</li><li>👎 53</li></div>
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
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return list;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        int level = Math.max(left, right) + 1;

        if (list.size() <= level) {
            list.add(new ArrayList<>());
        }

        list.get(level).add(node.val);
        return level;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
