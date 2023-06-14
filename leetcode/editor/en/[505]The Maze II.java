
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                int z = 0;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    z++;
                }
                x -= dir[0];
                y -= dir[1];
                if (dist[curr[0]][curr[1]] + z < dist[x][y]) {
                    dist[x][y] = dist[curr[0]][curr[1]] + z;
                    dq.add(new int[]{x, y});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
