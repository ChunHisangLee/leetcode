// 566
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        int rowIndex = 0;
        int columnIndex = 0;
        if (row * col != r * c)
            return mat;
        int[][] result = new int[r][c];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[rowIndex][columnIndex % c] = mat[i][j];
                columnIndex++;
                if (columnIndex % c == 0)
                    rowIndex++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
