
class Solution {
    int result = 0;

    public int diameter(Node root) {
        dfs(root);
        return result;
    }

    private int dfs(Node node) {
        if (node == null) {
            return 0;
        }

        int max1 = 0;
        int max2 = 0;

        for (Node child : node.children) {
            int depth = dfs(child);

            if (depth > max1) {
                max2 = max1;
                max1 = depth;
            } else if (depth > max2) {
                max2 = depth;
            }
        }

        result = Math.max(result, max1 + max2);
        return max1 + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
