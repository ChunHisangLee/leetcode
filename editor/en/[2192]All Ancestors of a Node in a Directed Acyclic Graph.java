
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> ancestors = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ancestors.add(new TreeSet<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (Set<Integer> set : ancestors) {
            result.add(new ArrayList<>(set));
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
