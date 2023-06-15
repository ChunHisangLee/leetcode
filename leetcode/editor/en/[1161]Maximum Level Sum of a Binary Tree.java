1161
        Maximum Level Sum of a Binary Tree
        2022-12-24 10:33:48
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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        dq.add(root);
        int max = Integer.MIN_VALUE;
        int res = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = dq.poll();
                count += curr.val;
                if (curr.left != null) {
                    dq.add(curr.left);
                }
                if (curr.right != null) {
                    dq.add(curr.right);
                }
            }
            list.add(count);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                res = i + 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
