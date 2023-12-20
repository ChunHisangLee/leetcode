
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int edge4 = 0;
        int edge2 = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    edge4++;

                    if (i > 0 && grid[i - 1][j] == 1) {
                        edge2++;
                    }

                    if (j > 0 && grid[i][j - 1] == 1) {
                        edge2++;
                    }
                }
            }
        }

        return edge4 * 4 - edge2 * 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
