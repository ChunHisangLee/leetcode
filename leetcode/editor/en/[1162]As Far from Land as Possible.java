1162
        As Far from Land as Possible
        2023-02-10 09:26:21

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dq.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        int res = 0;
        while (!dq.isEmpty()) {
            res++;
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + curr[0];
                    int y = dir[1] + curr[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1 || isVisited[x][y]) {
                        continue;
                    }
                    dq.add(new int[]{x, y});
                    isVisited[x][y] = true;
                }
            }
        }
        return res == 1 ? -1 : res - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
