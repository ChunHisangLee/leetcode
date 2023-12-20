/**
 * <p>On an <code>n x n</code> chessboard, a knight starts at the cell <code>(row, column)</code> and attempts to make exactly <code>k</code> moves. The rows and columns are <strong>0-indexed</strong>, so the top-left cell is <code>(0, 0)</code>, and the bottom-right cell is <code>(n - 1, n - 1)</code>.</p>
 *
 * <p>A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.</p>
 * <img src="https://assets.leetcode.com/uploads/2018/10/12/knight.png" style="width: 300px; height: 300px;" />
 * <p>Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.</p>
 *
 * <p>The knight continues moving until it has made exactly <code>k</code> moves or has moved off the chessboard.</p>
 *
 * <p>Return <em>the probability that the knight remains on the board after it has stopped moving</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3, k = 2, row = 0, column = 0
 * <strong>Output:</strong> 0.06250
 * <strong>Explanation:</strong> There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1, k = 0, row = 0, column = 0
 * <strong>Output:</strong> 1.00000
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 25</code></li>
 * <li><code>0 &lt;= k &lt;= 100</code></li>
 * <li><code>0 &lt;= row, column &lt;= n - 1</code></li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>Dynamic Programming</li></div></div><br><div><li>👍 2569</li><li>👎 359</li></div>
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[k + 1][n][n];
        return dyP(n, k, row, column);
    }

    private double dyP(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }
        if (k == 0) {
            return 1.0;
        }
        if (dp[k][row][column] != 0.0) {
            return dp[k][row][column];
        }
        double res = 0.0;
        for (int[] dir : dirs) {
            int x = row - dir[0];
            int y = column - dir[1];
            res += dyP(n, k - 1, x, y) / 8.0;
        }
        dp[k][row][column] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down - 6 ms
class Solution {
    int[][] dirs = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    double[][][] dp;

    public double knightProbability(int n, int k, int row, int column) {
        dp = new double[k + 1][n][n];
        return dyP(n, k, row, column);
    }

    private double dyP(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }
        if (k == 0) {
            return 1.0;
        }
        if (dp[k][row][column] != 0.0) {
            return dp[k][row][column];
        }
        double res = 0.0;
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = column + dir[1];
            res += dyP(n, k - 1, x, y) / 8.0;
        }
        dp[k][row][column] = res;
        return res;
    }
}


Bottom-Up  - 11 ms
class Solution {
    int[][] dirs = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1.0;
        for (int move = 1; move <= k; move++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int x = i - dir[0];
                        int y = j - dir[1];
                        if (x < 0 || x >= n || y < 0 || y >= n) {
                            continue;
                        }
                        dp[move][i][j] += dp[move - 1][x][y] / 8.0;
                    }
                }
            }
        }
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += dp[k][i][j];
            }
        }
        return res;
    }
}
 */