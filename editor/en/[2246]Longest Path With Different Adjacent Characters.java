
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int result = 0;

    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> children = new HashMap<>();

        for (int i = 0; i < parent.length; i++) {
            children.computeIfAbsent(parent[i], k -> new ArrayList<>()).add(i);
        }

        dfs(0, children, s);
        return result;
    }

    private int dfs(int node, Map<Integer, List<Integer>> children, String s) {
        int max1 = 0;
        int max2 = 0;

        if (children.containsKey(node)) {
            for (int child : children.get(node)) {
                int depth = dfs(child, children, s);

                if (s.charAt(node) != s.charAt(child)) {
                    if (depth > max1) {
                        max2 = max1;
                        max1 = depth;
                    } else if (depth > max2) {
                        max2 = depth;
                    }
                }
            }
        }

        result = Math.max(result, max1 + max2 + 1);
        return Math.max(max1, max2) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
