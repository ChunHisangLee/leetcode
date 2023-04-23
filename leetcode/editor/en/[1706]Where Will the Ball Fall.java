

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] grid;
    int m;
    int n;

    public int[] findBall(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = dfs(0, j);
        }
        return arr;
    }

    private int dfs(int i, int j) {
        if (i == m) {
            return j;
        }
        int y = j + grid[i][j];
        if (y < 0 || y >= n || grid[i][j] != grid[i][y]) {
            return -1;
        }
        return dfs(i + 1, y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
