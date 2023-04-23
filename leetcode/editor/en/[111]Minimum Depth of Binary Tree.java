111
        Minimum Depth of Binary Tree
        2022-12-01 17:18:41
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
這個比較快
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();
                if (curr.left == curr.right) {
                    return count;
                }
                if (curr.left != null) {
                    dq.add(curr.left);
                }
                if (curr.right != null) {
                    dq.add(curr.right);
                }
            }
        }
        return count;
    }
}
 */