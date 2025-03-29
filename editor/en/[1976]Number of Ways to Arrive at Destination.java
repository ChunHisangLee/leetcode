class Solution {
  public int countPaths(int n, int[][] roads) {
    List<int[]>[] graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] road : roads) {
      int u = road[0], v = road[1], t = road[2];
      graph[u].add(new int[] {v, t});
      graph[v].add(new int[] {u, t});
    }

    long[] dist = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[0] = 0;

    int[] ways = new int[n];
    ways[0] = 1;

    int mod = 1_000_000_007;
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
    pq.offer(new long[] {0, 0});

    while (!pq.isEmpty()) {
      long[] cur = pq.poll();
      long curDist = cur[0];
      int node = (int) cur[1];

      if (curDist > dist[node]) {
        continue;
      }

      for (int[] neighbor : graph[node]) {
        int next = neighbor[0];
        int time = neighbor[1];
        long newDist = curDist + time;

        if (newDist < dist[next]) {
          dist[next] = newDist;
          ways[next] = ways[node];
          pq.offer(new long[] {newDist, next});
        } else if (newDist == dist[next]) {
          ways[next] = (ways[next] + ways[node]) % mod;
        }
      }
    }

    return ways[n - 1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
