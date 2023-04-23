654
        Maximum Binary Tree
        2022-12-22 17:50:24
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return contruct(nums, 0, nums.length);
    }

    private TreeNode contruct(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int max = max(nums, left, right);
        TreeNode root = new TreeNode(nums[max]);
        root.left = contruct(nums, left, max);
        root.right = contruct(nums, max + 1, right);
        return root;
    }

    private int max(int[] nums, int left, int right) {
        int max = left;
        for (int i = left; i < right; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
