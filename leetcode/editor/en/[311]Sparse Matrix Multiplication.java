
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat2.length;
        int n = mat2[0].length;
        int[][] res = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < k; y++) {
                if (mat1[x][y] != 0) {
                    for (int z = 0; z < n; z++) {
                        res[x][z] += mat1[x][y] * mat2[y][z];
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
