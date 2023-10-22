
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
    Set<Integer> visited = new HashSet<>();

    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.right != null && visited.contains(root.right.val)) {
            return null;
        }

        visited.add(root.val);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        Deque<TreeNode[]> deque = new ArrayDeque<>();
        deque.add(new TreeNode[]{root, null});

        while (!deque.isEmpty()) {
            int n = deque.size();
            Set<TreeNode> visited = new HashSet<>();

            for (int i = 0; i < n; i++) {
                TreeNode[] curr = deque.poll();
                TreeNode node = curr[0];
                TreeNode parent = curr[1];

                if (visited.contains(node.right)) {
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }

                    return root;
                }

                visited.add(node);

                if (node.right != null) {
                    deque.add(new TreeNode[]{node.right, node});
                }
                if (node.left != null) {
                    deque.add(new TreeNode[]{node.left, node});
                }
            }
        }

        return root;
    }
}
 */