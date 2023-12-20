
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int o = mat2.length;
        int n = mat2[0].length;
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < o; j++) {
                if (mat1[i][j] != 0) {
                    for (int k = 0; k < n; k++) {
                        arr[i][k] += mat1[i][j] * mat2[j][k];
                    }
                }
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
