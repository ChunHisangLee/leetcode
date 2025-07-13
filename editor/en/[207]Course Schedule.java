//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    int[] inDegree = new int[numCourses];
    for (int[] pre : prerequisites) {
      int course = pre[0];
      int before = pre[1];
      adj.get(before).add(course);
      inDegree[course]++;
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int u = queue.poll();
      count++;
      for (int v : adj.get(u)) {
        inDegree[v]--;
        if (inDegree[v] == 0) {
          queue.offer(v);
        }
      }
    }

    return count == numCourses;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
