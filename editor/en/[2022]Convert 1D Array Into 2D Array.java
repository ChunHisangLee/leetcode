2022
        Convert 1DArray Into 2DArray
        2023-02-07 15:01:51

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int[][] arr = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[index];
                index++;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
