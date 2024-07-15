
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        int distanceP = findLevel(lca, p, 0);
        int distanceQ = findLevel(lca, q, 0);
        return distanceP + distanceQ;
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    private int findLevel(TreeNode root, int value, int level) {
        if (root == null) {
            return -1;
        }

        if (root.val == value) {
            return level;
        }

        int leftLevel = findLevel(root.left, value, level + 1);

        if (leftLevel == -1) {
            return findLevel(root.right, value, level + 1);
        }

        return leftLevel;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
