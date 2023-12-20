
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] arr = new double[query_row + 1];
        arr[0] = (double) poured;

        for (int i = 0; i < query_row; i++) {
            double[] nextArr = new double[query_row + 1];

            for (int j = 0; j <= i; j++) {
                double temp = (arr[j] - 1) / 2;

                if (temp > 0) {
                    nextArr[j] += temp;
                    nextArr[j + 1] += temp;
                }
            }

            arr = nextArr;
        }

        return Math.min(1, arr[query_glass]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
