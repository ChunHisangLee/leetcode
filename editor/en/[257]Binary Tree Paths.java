
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
    List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return list;
    }

    public void dfs(TreeNode node, String str) {
        if (node == null) {
            return;
        }
        str += Integer.toString(node.val);
        if (node.left == null && node.right == null) {
            list.add(str);
        }
        str += "->";
        dfs(node.left, str);
        dfs(node.right, str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
