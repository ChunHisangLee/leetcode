652
        Find Duplicate Subtrees
        2023-02-28 09:19:26
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
    List<TreeNode> list = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return list;
    }

    public String helper(TreeNode node) {
        if (node == null) {
            return "N";
        }
        String left = helper(node.left);
        String right = helper(node.right);
        String curr = node.val + "," + left + "," + right;
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        if (map.get(curr) == 2) {
            list.add(node);
        }
        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
