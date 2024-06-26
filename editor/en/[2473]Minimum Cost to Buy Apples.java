
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int cityA = road[0] - 1, cityB = road[1] - 1, cost = road[2];
            graph.get(cityA).add(new Pair<Integer, Integer>(cityB, cost));
            graph.get(cityB).add(new Pair<Integer, Integer>(cityA, cost));
        }

        long[] result = new long[n];

        for (int startCity = 0; startCity < n; startCity++) {
            result[startCity] = appleCost[startCity];
        }

        Queue<Pair<Long, Integer>> heap = new PriorityQueue<>((a, b) -> Long.compare(a.getKey(), b.getValue()));

        for (int startCity = 0; startCity < n; startCity++) {
            heap.add(new Pair<>((long) appleCost[startCity], startCity));
        }

        while (!heap.isEmpty()) {
            Pair<Long, Integer> current = heap.poll();
            long totalCost = current.getKey();
            int currCity = current.getValue();

            if (result[currCity] < totalCost) {
                continue;
            }

            for (Pair<Integer, Integer> next : graph.get(currCity)) {
                int neighbor = next.getKey(), cost = next.getValue();

                if (result[neighbor] > result[currCity] + (k + 1) * cost) {
                    result[neighbor] = result[currCity] + (k + 1) * cost;
                    heap.add(new Pair<Long, Integer>(result[neighbor], neighbor));
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
