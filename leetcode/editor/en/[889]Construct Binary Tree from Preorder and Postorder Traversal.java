/**
 * <p>Given two integer arrays, <code>preorder</code> and <code>postorder</code> where <code>preorder</code> is the preorder traversal of a binary tree of <strong>distinct</strong> values and <code>postorder</code> is the postorder traversal of the same tree, reconstruct and return <em>the binary tree</em>.</p>
 *
 * <p>If there exist multiple answers, you can <strong>return any</strong> of them.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/07/24/lc-prepost.jpg" style="width: 304px; height: 265px;" />
 * <pre>
 * <strong>Input:</strong> preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * <strong>Output:</strong> [1,2,3,4,5,6,7]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> preorder = [1], postorder = [1]
 * <strong>Output:</strong> [1]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= preorder.length &lt;= 30</code></li>
 * <li><code>1 &lt;= preorder[i] &lt;= preorder.length</code></li>
 * <li>All the values of <code>preorder</code> are <strong>unique</strong>.</li>
 * <li><code>postorder.length == preorder.length</code></li>
 * <li><code>1 &lt;= postorder[i] &lt;= postorder.length</code></li>
 * <li>All the values of <code>postorder</code> are <strong>unique</strong>.</li>
 * <li>It is guaranteed that <code>preorder</code> and <code>postorder</code> are the preorder traversal and postorder traversal of the same binary tree.</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Array</li><li>Hash Table</li><li>Divide and Conquer</li><li>Tree</li><li>Binary Tree</li></div></div><br><div><li>👍 2444</li><li>👎 98</li></div>
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
    int preIndex;
    int postIndex;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode node = new TreeNode(preorder[preIndex]);
        preIndex++;
        if (node.val != postorder[postIndex]) {
            node.left = constructFromPrePost(preorder, postorder);
        }
        if (node.val != postorder[postIndex]) {
            node.right = constructFromPrePost(preorder, postorder);
        }
        postIndex++;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
