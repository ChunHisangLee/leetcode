515
        Find Largest Value in Each Tree Row
        2022-12-03 15:33:22
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
    List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return result;
        }

        getMax(root, 0);
        return result;
    }

    private void getMax(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (result.size() <= depth) {
            result.add(root.val);
        } else if (result.get(depth) < root.val) {
            result.set(depth, root.val);
        }

        getMax(root.left, depth + 1);
        getMax(root.right, depth + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = deque.poll();
                max = Math.max(max, curr.val);

                if (curr.left != null) {
                    deque.offer(curr.left);
                }

                if (curr.right != null) {
                    deque.offer(curr.right);
                }
            }

            result.add(max);
        }

        return result;
    }
}
 */
