
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int min = matrix[row - 1][col];

                if (col > 0) {
                    min = Math.min(min, matrix[row - 1][col - 1]);
                }

                if (col < n - 1) {
                    min = Math.min(min, matrix[row - 1][col + 1]);
                }

                matrix[row][col] += min;
            }
        }

        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)