// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
    int n = edges1.length + 1;
    int m = edges2.length + 1;

    List<Integer>[] adj1 = buildAdj(n, edges1);
    List<Integer>[] adj2 = buildAdj(m, edges2);

    int[] count1 = countWithinK(adj1, k);
    int[] count2 = countWithinK(adj2, k - 1);

    int maxCount2 = 0;
    for (int c : count2) {
      if (c > maxCount2) {
        maxCount2 = c;
      }
    }

    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = count1[i] + maxCount2;
    }
    return answer;
  }

  private List<Integer>[] buildAdj(int size, int[][] edges) {
    List<Integer>[] adj = new ArrayList[size];
    for (int i = 0; i < size; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int[] e : edges) {
      int u = e[0], v = e[1];
      adj[u].add(v);
      adj[v].add(u);
    }
    return adj;
  }

  private int[] countWithinK(List<Integer>[] adj, int limit) {
    int n = adj.length;
    int[] counts = new int[n];
    if (limit < 0) {
      return counts;
    }

    Deque<Integer> queue = new ArrayDeque<>(n);
    int[] dist = new int[n];
    for (int start = 0; start < n; start++) {
      for (int i = 0; i < n; i++) {
        dist[i] = -1;
      }
      dist[start] = 0;
      queue.clear();
      queue.add(start);

      int cnt = 1;
      while (!queue.isEmpty()) {
        int u = queue.poll();
        if (dist[u] == limit) {
          continue;
        }
        for (int v : adj[u]) {
          if (dist[v] == -1) {
            dist[v] = dist[u] + 1;
            if (dist[v] <= limit) {
              cnt++;
              queue.add(v);
            }
          }
        }
      }
      counts[start] = cnt;
    }
    return counts;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
