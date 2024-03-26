//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[src] = 0;

        for (int i = 0; i <= k; i++) {
            dp = updateMinCost(flights, dp);
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }

    private int[] updateMinCost(int[][] flights, int[] dp) {
        int[] temp = dp.clone();

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            if (dp[from] < Integer.MAX_VALUE) {
                temp[to] = Math.min(temp[to], dp[from] + price);
            }
        }

        return temp;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
/*
BFS: - 7ms
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] arr : flights) {
            map.computeIfAbsent(arr[0], value -> new ArrayList<>()).add(new int[]{arr[1], arr[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{src, 0});
        int stops = 0;
        while (!dq.isEmpty() && stops <= k) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                int node = curr[0];
                int dists = curr[1];
                if (!map.containsKey(node)) {
                    continue;
                }
                for (int[] arr : map.get(node)) {
                    int nei = arr[0];
                    int price = arr[1];
                    if (price + dists < dist[nei]) {
                        dist[nei] = price + dists;
                        dq.add(new int[]{nei, dist[nei]});
                    }
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}


Bellman Ford: - 6ms
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] curr = new int[n];
        int[] prev = new int[n];
        Arrays.fill(curr, Integer.MAX_VALUE);
        Arrays.fill(prev, Integer.MAX_VALUE);
        prev[src] = 0;
        for (int i = 0; i <= k; i++) {
            boolean update = false;
            for (int[] arr : flights) {
                if (prev[arr[0]] < Integer.MAX_VALUE) {
                    curr[arr[1]] = Math.min(curr[arr[1]], prev[arr[0]] + arr[2]);
                    update = true;
                }
            }
            if (!update) {
                break;
            }
            prev = curr.clone();
        }
        return curr[dst] == Integer.MAX_VALUE ? -1 : curr[dst];
    }
}


Dijkstra: - 8ms
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] arr : flights) {
            map.computeIfAbsent(arr[0], value -> new ArrayList<>()).add(new int[]{arr[1], arr[2]});
        }
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dist = curr[0];
            int node = curr[1];
            int steps = curr[2];
            if (steps > stops[node] || steps > k + 1) {
                continue;
            }
            stops[node] = steps;
            if (node == dst) {
                return dist;
            }
            if (!map.containsKey(node)) {
                continue;
            }
            for (int[] arr : map.get(node)) {
                pq.add(new int[]{dist + arr[1], arr[0], steps + 1});
            }
        }
        return -1;
    }
}
 */