// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }
    for (int[] preq : prerequisites) {
      int course = preq[0];
      int pre = preq[1];
      adj.get(pre).add(course);
      indegree[course]++;
    }

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }

    int visited = 0;
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      visited++;

      for (int next : adj.get(curr)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          queue.add(next);
        }
      }
    }

    return numCourses == visited;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
