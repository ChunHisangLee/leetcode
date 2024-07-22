
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] highway : highways) {
            int u = highway[0];
            int v = highway[1];
            int toll = highway[2];
            graph[u].add(new int[]{v, toll});
            graph[v].add(new int[]{u, toll});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, discounts});
        int[][] dist = new int[n][discounts + 1];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][discounts] = 0;

        while (!pq.isEmpty()) {
            int[] state = pq.poll();
            int currentCost = state[0];
            int u = state[1];
            int remainingDiscounts = state[2];

            if (u == n - 1) {
                return currentCost;
            }

            if (currentCost > dist[u][remainingDiscounts]) {
                continue;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int toll = edge[1];

                if (currentCost + toll < dist[v][remainingDiscounts]) {
                    dist[v][remainingDiscounts] = currentCost + toll;
                    pq.add(new int[]{currentCost + toll, v, remainingDiscounts});
                }

                if (remainingDiscounts > 0) {
                    int discountedCost = currentCost + toll / 2;

                    if (discountedCost < dist[v][remainingDiscounts - 1]) {
                        dist[v][remainingDiscounts - 1] = discountedCost;
                        pq.add(new int[]{discountedCost, v, remainingDiscounts - 1});
                    }
                }
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
