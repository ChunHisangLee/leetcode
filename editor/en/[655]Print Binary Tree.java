
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int m = height + 1;
        int n = (int) Math.pow(2, height + 1) - 1;

        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add("");
            }

            res.add(row);
        }

        placeNodes(root, res, 0, 0, n - 1, height);

        return res;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void placeNodes(TreeNode node, List<List<String>> res, int row, int left, int right, int height) {
        if (node == null) {
            return;
        }

        int mid = (left + right) / 2;
        res.get(row).set(mid, Integer.toString(node.val));

        placeNodes(node.left, res, row + 1, left, mid - 1, height);
        placeNodes(node.right, res, row + 1, mid + 1, right, height);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
