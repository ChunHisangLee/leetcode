// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countCompleteComponents(int n, int[][] edges) {
    List<Set<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      graph.add(new HashSet<>());
    }

    for (int[] edge : edges) {
      int u = edge[0], v = edge[1];
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    boolean[] visited = new boolean[n];
    int completeCount = 0;

    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        List<Integer> component = new ArrayList<>();
        dfs(i, graph, visited, component);

        if (isComplete(component, graph)) {
          completeCount++;
        }
      }
    }

    return completeCount;
  }

  private void dfs(int node, List<Set<Integer>> graph, boolean[] visited, List<Integer> component) {
    visited[node] = true;
    component.add(node);

    for (int neighbor : graph.get(node)) {
      if (!visited[neighbor]) {
        dfs(neighbor, graph, visited, component);
      }
    }
  }

  private boolean isComplete(List<Integer> component, List<Set<Integer>> graph) {
    int size = component.size();

    if (size == 1) {
      return true;
    }

    for (int v : component) {
      int count = 0;

      for (int neighbor : graph.get(v)) {
        if (component.contains(neighbor)) {
          count++;
        }
      }

      if (count != size - 1) return false;
    }

    return true;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
