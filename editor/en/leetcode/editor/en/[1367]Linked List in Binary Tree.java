
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (dfs(head, root)) {
            return true;
        }

        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }

        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
