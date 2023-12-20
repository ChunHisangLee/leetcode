671
        Second Minimum Node In a Binary Tree
        2022-12-27 09:57:54
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
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> set = new TreeSet<>();
        dfs(root, set);
        int index = 0;
        for (int num : set) {
            if (index == 1) {
                return num;
            }
            index++;
        }
        return -1;
    }

    private void dfs(TreeNode node, Set<Integer> set) {
        if (node != null) {
            set.add(node.val);
            dfs(node.left, set);
            dfs(node.right, set);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
