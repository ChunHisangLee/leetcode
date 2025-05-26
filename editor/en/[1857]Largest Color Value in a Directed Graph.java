// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public int largestPathValue(String colors, int[][] edges) {
    int n = colors.length();
    List<List<Integer>> adj = new ArrayList<>(n);
    int[] inDegree = new int[n];
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    for (int[] e : edges) {
      adj.get(e[0]).add(e[1]);
      inDegree[e[1]]++;
    }

    int[][] dp = new int[n][26];
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        q.offer(i);
      }
      dp[i][colors.charAt(i) - 'a'] = 1;
    }

    int processed = 0;
    int result = 0;

    while (!q.isEmpty()) {
      int u = q.poll();
      processed++;
      for (int c = 0; c < 26; c++) {
        result = Math.max(result, dp[u][c]);
      }
      for (int v : adj.get(u)) {
        for (int c = 0; c < 26; c++) {
          int candidate = dp[u][c] + (colors.charAt(v) - 'a' == c ? 1 : 0);
          if (candidate > dp[v][c]) {
            dp[v][c] = candidate;
          }
        }
        if (--inDegree[v] == 0) {
          q.offer(v);
        }
      }
    }

    return processed == n ? result : -1;
  }
}
//read the official solution
//leetcode submit region end(Prohibit modification and deletion)
