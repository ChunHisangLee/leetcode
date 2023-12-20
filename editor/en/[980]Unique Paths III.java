980
        Unique Paths III
        2022-12-31 10:50:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    int[][] grid;
    int count;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int startX = -1;
        int startY = -1;
        int zeros = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        this.grid = grid;
        return backtrack(startX, startY, zeros);
    }

    private int backtrack(int i, int j, int zeros) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            if (zeros == -1) {
                return 1;
            }
            return 0;
        }
        zeros--;
        grid[i][j] = -1;
        int count = backtrack(i + 1, j, zeros) + backtrack(i, j + 1, zeros) + backtrack(i - 1, j, zeros) + backtrack(i, j - 1, zeros);
        zeros++;
        grid[i][j] = 0;
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
