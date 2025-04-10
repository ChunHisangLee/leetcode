
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }

        int guardedCount = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];

            for (int[] dir : directions) {
                int x = r + dir[0];
                int y = c + dir[1];

                while (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 1) {
                    if (grid[x][y] == 0) {
                        guardedCount++;
                        grid[x][y] = -1;
                    }

                    x += dir[0];
                    y += dir[1];
                }
            }
        }

        return m * n - guards.length - walls.length - guardedCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
