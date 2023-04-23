
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int len = mat.length;
        for (int i = 0, j = len - 1; j >= 0; i++, j--) {
            sum += mat[i][i] + mat[i][j];
        }
        if (mat.length % 2 == 1) {
            sum -= mat[len / 2][len / 2];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
