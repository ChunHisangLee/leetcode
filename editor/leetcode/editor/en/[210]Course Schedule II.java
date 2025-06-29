// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private static final int UNVISITED = 0;
  private static final int VISITING = 1;
  private static final int VISITED = 2;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      int course = pre[0];
      int prereq = pre[1];
      adj.get(prereq).add(course);
    }

    List<Integer> postOrder = new ArrayList<>();
    int[] state = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      if (state[i] == UNVISITED) {
        if (!dfs(i, adj, state, postOrder)) {
          return new int[0];
        }
      }
    }

    Collections.reverse(postOrder);
    int[] order = new int[postOrder.size()];

    for (int i = 0; i < order.length; i++) {
      order[i] = postOrder.get(i);
    }

    return order;
  }

  private boolean dfs(int u, List<List<Integer>> adj, int[] state, List<Integer> postOrder) {
    state[u] = VISITING;

    for (int v : adj.get(u)) {
      if (state[v] == UNVISITED) {
        if (!dfs(v, adj, state, postOrder)) {
          return false;
        }
      } else if (state[v] == VISITING) {
        return false;
      }
    }

    state[u] = VISITED;
    postOrder.add(u);
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
