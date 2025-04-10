
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private Map<Integer, Integer> leftMap = new HashMap<>();
    private Map<Integer, Integer> rightMap = new HashMap<>();
    private Map<Integer, Integer> removed = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        populateHeights(root, 0);
        calculateRemovedHeights(root, 0);
        int[] output = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            output[i] = removed.get(queries[i]);
        }

        return output;
    }

    private void calculateRemovedHeights(TreeNode node, int height) {
        if (node == null) {
            return;
        }

        removed.put(node.val, height);
        calculateRemovedHeights(node.left, Math.max(height, rightMap.get(node.val)));
        calculateRemovedHeights(node.right, Math.max(height, leftMap.get(node.val)));
    }

    private int populateHeights(TreeNode node, int height) {
        if (node == null) {
            return height - 1;
        }

        leftMap.put(node.val, populateHeights(node.left, height + 1));
        rightMap.put(node.val, populateHeights(node.right, height + 1));

        return Math.max(leftMap.get(node.val), rightMap.get(node.val));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
