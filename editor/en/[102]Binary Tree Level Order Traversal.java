// 102
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelHelper(result, root, 0);
        return result;
    }

    public void levelHelper(List<List<Integer>> result, TreeNode root, int height) {
        if (root == null)
            return;
        if (height >= result.size()) {
            List<Integer> newLevel = new LinkedList<>();
            result.add(newLevel);
        }
        result.get(height).add(root.val);
        levelHelper(result, root.left, height + 1);
        levelHelper(result, root.right, height + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
