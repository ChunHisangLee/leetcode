
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.offer(i);
                color[i] = 0;

                while (!deque.isEmpty()) {
                    int current = deque.poll();

                    for (int neighbor : graph[current]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[current];
                            deque.offer(neighbor);
                        } else if (color[neighbor] == color[current]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
