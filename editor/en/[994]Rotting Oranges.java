994
        Rotting Oranges
        2023-02-06 22:17:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    dq.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        int res = 0;
        while (!dq.isEmpty()) {
            res++;
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
                        continue;
                    }
                    count--;
                    grid[x][y] = 2;
                    dq.add(new int[]{x, y});
                }
            }
        }
        return count == 0 ? res - 1 : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
