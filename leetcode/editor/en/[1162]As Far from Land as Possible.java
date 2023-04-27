1162
        As Far from Land as Possible
        2023-02-10 09:26:21

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dq.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        int count = 0;
        while (!dq.isEmpty()) {
            count++;
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || isVisited[x][y] == true) {
                        continue;
                    }
                    dq.add(new int[]{x, y});
                    isVisited[x][y] = true;
                }
            }
        }
        return count == 1 ? -1 : count - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
