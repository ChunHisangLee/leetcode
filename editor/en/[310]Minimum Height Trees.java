310

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        List<List<Integer>> graph = new ArrayList<>();
        int[] degree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Deque<Integer> leaves = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {
            int size = leaves.size();
            remainingNodes -= size;

            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();

                for (int neighbor : graph.get(leaf)) {
                    degree[neighbor]--;

                    if (degree[neighbor] == 1) {
                        leaves.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(leaves);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
