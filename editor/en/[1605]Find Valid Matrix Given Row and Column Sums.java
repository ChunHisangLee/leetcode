//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        int i = rows - 1;
        int j = cols - 1;

        while (i >= 0 && j >= 0) {
            if (rowSum[i] <= colSum[j]) {
                matrix[i][j] = rowSum[i];
                colSum[j] -= rowSum[i];
                i--;
            } else {
                matrix[i][j] = colSum[j];
                rowSum[i] -= colSum[j];
                j--;
            }
        }

        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
