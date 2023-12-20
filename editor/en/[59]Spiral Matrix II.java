

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int count = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                mat[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = count;
                count++;
            }
            right--;
            if (left <= right) {
                for (int i = right; i >= left; i--) {
                    mat[bottom][i] = count;
                    count++;
                }
                bottom--;
            }
            if (top <= bottom) {
                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = count;
                    count++;
                }
                left++;
            }
        }
        return mat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
