1886
        Determine Whether Matrix Can Be Obtained By Rotation
        2022-11-28 09:29:35

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = n - 1 - i;
                int y = n - 1 - j;
                if (mat[i][j] == target[i][j]) {
                    r0++;
                }
                if (mat[i][j] == target[y][i]) {
                    r1++;
                }
                if (mat[i][j] == target[x][y]) {
                    r2++;
                }
                if (mat[i][j] == target[j][x]) {
                    r3++;
                }
            }
        }
        int total = n * n;
        return r0 == total || r1 == total || r2 == total || r3 == total;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
