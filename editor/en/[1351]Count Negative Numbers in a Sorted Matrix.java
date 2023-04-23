// 1351
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0)
                    result++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
