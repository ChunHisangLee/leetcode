
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int n;

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, dq);
                    int count = 0;
                    while (!dq.isEmpty()) {
                        int size = dq.size();
                        for (int k = 0; k < size; k++) {
                            int[] cell = dq.poll();
                            for (int[] dir : dirs) {
                                int x = cell[0] + dir[0];
                                int y = cell[1] + dir[1];
                                if (x < 0 || x >= n || y < 0 || y >= n) {
                                    continue;
                                }
                                if (grid[x][y] == 0) {
                                    dq.add(new int[]{x, y});
                                    grid[x][y] = -1;
                                } else if (grid[x][y] == 1) {
                                    return count;
                                }
                            }
                        }
                        count++;
                    }
                }
            }
        }
        return 0;
    }

    public void dfs(int x, int y, int[][] grid, Deque<int[]> dq) {
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) {
            return;
        }
        grid[x][y] = -1;
        dq.add(new int[]{x, y});
        dfs(x - 1, y, grid, dq);
        dfs(x + 1, y, grid, dq);
        dfs(x, y - 1, grid, dq);
        dfs(x, y + 1, grid, dq);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
