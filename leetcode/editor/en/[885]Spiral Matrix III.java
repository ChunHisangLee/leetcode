

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int up = rStart;
        int bottum = rStart;
        int left = cStart;
        int right = cStart;
        int[][] res = new int[rows * cols][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        int index = 1;
        while (up >= 0 || bottum < rows || left >= 0 || right < cols) {
            for (int i = up + 1; i <= bottum && right < cols; i++) {
                if (i >= 0 && i < rows) {
                    res[index][0] = i;
                    res[index][1] = right;
                    index++;
                }
            }
            for (int i = right - 1; i >= left && bottum < rows; i--) {
                if (i >= 0 && i <= cols) {
                    res[index][0] = bottum;
                    res[index][1] = i;
                    index++;
                }
            }
            for (int i = bottum - 1; i >= up && left > -1; i--) {
                if (i >= 0 && i < rows) {
                    res[index][0] = i;
                    res[index][1] = left;
                    index++;
                }
            }
            for (int i = left + 1; i <= right && up > -1; i++) {
                if (i >= 0 && i < cols) {
                    res[index][0] = up;
                    res[index][1] = i;
                    index++;
                }
            }
            up = (up > -1) ? up - 1 : -1;
            bottum = (bottum < rows) ? bottum + 1 : bottum;
            left = (left > -1) ? left - 1 : -1;
            right = (right < cols) ? right + 1 : right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
