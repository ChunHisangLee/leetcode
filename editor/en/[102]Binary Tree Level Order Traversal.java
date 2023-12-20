102
        Binary Tree Level Order Traversal
        2022-12-02 12:27:57
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
        list.get(level).add(node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
