
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arrs = new double[query_row + 1][query_row + 1];

        arrs[0][0] = (double) poured;

        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = (arrs[i][j] - 1.0) / 2.0;

                if (temp > 0) {
                    arrs[i + 1][j] += temp;
                    arrs[i + 1][j + 1] += temp;
                }
            }
        }

        return Math.min(1, arrs[query_row][query_glass]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
