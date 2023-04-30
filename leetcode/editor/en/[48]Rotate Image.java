48
        Rotate Image
        2022-12-05 02:14:26

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int x = n - 1 - i;
                int y = n - 1 - j;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[y][i];
                matrix[y][i] = matrix[x][y];
                matrix[x][y] = matrix[j][x];
                matrix[j][x] = temp;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public void rotate(int[][] matrix) {
        doTranspose(matrix);
        doReverse(matrix);
    }

    private void doTranspose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void doReverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
 */