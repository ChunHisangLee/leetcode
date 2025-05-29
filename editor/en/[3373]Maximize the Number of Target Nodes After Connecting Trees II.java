// leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
  public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
    int n = edges1.length + 1;
    int m = edges2.length + 1;

    List<Integer>[] adj1 = makeAdj(n, edges1);
    List<Integer>[] adj2 = makeAdj(m, edges2);

    int[] color1 = new int[n];
    int[] cnt1 = bfsColor(adj1, color1);

    int[] color2 = new int[m];
    int[] cnt2 = bfsColor(adj2, color2);

    int minClass2 = Math.min(cnt2[0], cnt2[1]);
    int bestTree2 = m - minClass2;

    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = cnt1[color1[i]] + bestTree2;
    }
    return answer;
  }

  private List<Integer>[] makeAdj(int V, int[][] edges) {
    List<Integer>[] adj = new List[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int[] e : edges) {
      int u = e[0], v = e[1];
      adj[u].add(v);
      adj[v].add(u);
    }
    return adj;
  }

  private int[] bfsColor(List<Integer>[] adj, int[] color) {
    int V = adj.length;
    Arrays.fill(color, -1);
    int[] cnt = new int[2];

    Queue<Integer> q = new ArrayDeque<>();
    q.offer(0);
    color[0] = 0;
    cnt[0]++;

    while (!q.isEmpty()) {
      int u = q.poll();
      for (int v : adj[u]) {
        if (color[v] < 0) {
          color[v] = color[u] ^ 1;
          cnt[color[v]]++;
          q.offer(v);
        }
      }
    }
    return cnt;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
