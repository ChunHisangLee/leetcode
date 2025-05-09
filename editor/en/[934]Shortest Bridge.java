
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] grid;
    Deque<int[]> dq = new ArrayDeque<>();
    int n;

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    int count = 0;
                    while (!dq.isEmpty()) {
                        int size = dq.size();
                        for (int k = 0; k < size; k++) {
                            int[] curr = dq.poll();
                            for (int[] dir : dirs) {
                                int x = curr[0] + dir[0];
                                int y = curr[1] + dir[1];
                                if (x < 0 || x >= n || y < 0 || y >= n) {
                                    continue;
                                }
                                if (grid[x][y] == 1) {
                                    return count;
                                } else if (grid[x][y] == 0) {
                                    dq.add(new int[]{x, y});
                                    grid[x][y] = -1;
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

    public void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) {
            return;
        }
        dq.add(new int[]{x, y});
        grid[x][y] = -1;
        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
