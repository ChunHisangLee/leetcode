
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];
        int[][] diff = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = 2 * (rowOnes[i] + colOnes[j]) - (m + n);
            }
        }

        return diff;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
