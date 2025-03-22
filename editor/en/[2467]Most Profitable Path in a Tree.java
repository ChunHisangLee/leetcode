// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
    int n = amount.length;
    List<Integer>[] graph = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] e : edges) {
      int u = e[0], v = e[1];
      graph[u].add(v);
      graph[v].add(u);
    }

    int[] parent = new int[n];
    Arrays.fill(parent, -1);
    dfsParent(0, -1, graph, parent);

    int[] bobTime = new int[n];
    Arrays.fill(bobTime, Integer.MAX_VALUE);
    int time = 0;
    int cur = bob;

    while (cur != -1) {
      bobTime[cur] = time;
      cur = parent[cur];
      time++;
    }

    return dfsAlice(0, -1, 0, graph, amount, bobTime);
  }

  private void dfsParent(int node, int par, List<Integer>[] graph, int[] parent) {
    parent[node] = par;

    for (int nxt : graph[node]) {
      if (nxt == par) {
        continue;
      }

      dfsParent(nxt, node, graph, parent);
    }
  }

  private int dfsAlice(
      int node, int par, int time, List<Integer>[] graph, int[] amount, int[] bobTime) {
    int currIncome = 0;

    if (time < bobTime[node]) {
      currIncome = amount[node];
    } else if (time == bobTime[node]) {
      currIncome = amount[node] / 2;
    }

    if (node != 0 && graph[node].size() == 1) {
      return currIncome;
    }

    int maxChildIncome = Integer.MIN_VALUE;

    for (int nxt : graph[node]) {
      if (nxt == par) {
        continue;
      }

      int childIncome = dfsAlice(nxt, node, time + 1, graph, amount, bobTime);
      maxChildIncome = Math.max(maxChildIncome, childIncome);
    }

    if (maxChildIncome == Integer.MIN_VALUE) {
      return currIncome;
    }

    return currIncome + maxChildIncome;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
