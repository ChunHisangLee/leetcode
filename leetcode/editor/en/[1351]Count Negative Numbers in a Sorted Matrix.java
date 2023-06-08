
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = m - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                i--;
                count += n - j;
            } else {
                j++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
