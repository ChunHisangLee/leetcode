
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            boolean same = true;
            boolean opposite = true;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] != grid[0][j]) {
                    same = false;
                }

                if (grid[i][j] != 1 - grid[0][j]) {
                    opposite = false;
                }
            }

            if (!same && !opposite) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
