655
        Print Binary Tree
        2022-12-22 18:07:55
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
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int m = h + 1;
        int n = (int) Math.pow(2, h + 1) - 1;
        List<List<String>> res = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            String[] list = new String[n];
            Arrays.fill(list, "");
            res.add(Arrays.asList(list));
        }

        Queue<BFSNode> q = new LinkedList<>();
        q.add(new BFSNode(root, 0, (n - 1) / 2));

        while (!q.isEmpty()) {
            BFSNode bfs = q.remove();
            res.get(bfs.row).set(bfs.col, "" + bfs.node.val);

            int colOffset = (int) Math.pow(2, h - bfs.row - 1);
            if (bfs.node.left != null) {
                q.add(new BFSNode(bfs.node.left, bfs.row + 1, bfs.col - colOffset));
            }

            if (bfs.node.right != null) {
                q.add(new BFSNode(bfs.node.right, bfs.row + 1, bfs.col + colOffset));
            }
        }
        return res;
    }

    int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }
}

class BFSNode {
    TreeNode node;
    int row, col;

    BFSNode(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
