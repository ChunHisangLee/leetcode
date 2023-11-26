
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }

        for (int[] arr : matrix) {
            Arrays.sort(arr);

            for (int j = n - 1; j >= 0; j--) {
                int height = arr[j];
                max = Math.max(max, height * (n - j));
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
