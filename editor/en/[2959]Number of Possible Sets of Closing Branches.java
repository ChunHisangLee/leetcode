
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            graph.computeIfAbsent(u, k -> new HashMap<>());
            graph.computeIfAbsent(v, k -> new HashMap<>());

            if (!graph.get(u).containsKey(v) || graph.get(u).get(v) > w) {
                graph.get(u).put(v, w);
            }
            if (!graph.get(v).containsKey(u) || graph.get(v).get(u) > w) {
                graph.get(v).put(u, w);
            }
        }

        return countValidCombinations(n, maxDistance, graph, new boolean[n], 0);
    }

    private int countValidCombinations(int n, int maxDistance, Map<Integer, Map<Integer, Integer>> graph, boolean[] closed, int start) {
        int count = 0;

        if (start == n) {
            if (isValidSubset(closed, n, maxDistance, graph)) {
                count++;
            }
        } else {
            closed[start] = true;
            count += countValidCombinations(n, maxDistance, graph, closed, start + 1);

            closed[start] = false;
            count += countValidCombinations(n, maxDistance, graph, closed, start + 1);
        }

        return count;
    }

    private boolean isValidSubset(boolean[] closed, int n, int maxDistance, Map<Integer, Map<Integer, Integer>> graph) {
        int[][] distances = new int[n][n];

        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
            if (!closed[i]) {
                for (int j : graph.getOrDefault(i, new HashMap<>()).keySet()) {
                    if (!closed[j]) {
                        distances[i][j] = distances[j][i] = graph.get(i).get(j);
                    }
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!closed[i] && !closed[j] && distances[i][j] > maxDistance) {
                    return false;
                }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
