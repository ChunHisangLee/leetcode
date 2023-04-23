329
        Longest Increasing Path in a Matrix
        2023-02-18 12:15:56

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] matrix;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int[][] arr = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(arr, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] arr, int i, int j) {
        if (arr[i][j] != 0) {
            return arr[i][j];
        }
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[i][j] <= matrix[x][y]) {
                continue;
            }
            arr[i][j] = Math.max(arr[i][j], dfs(arr, x, y));
        }
        return ++arr[i][j];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
