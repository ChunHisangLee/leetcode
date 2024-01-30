
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    double[][][] memo;

    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[k + 1][n][n];
        return getProb(n, k, row, column);
    }

    private double getProb(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }

        if (k == 0) {
            return 1.0;
        }

        if (memo[k][row][column] != 0.0) {
            return memo[k][row][column];
        }

        double res = 0.0;

        for (int[] dir : dirs) {
            int x = row - dir[0];
            int y = column - dir[1];
            res += getProb(n, k - 1, x, y) / 8.0;
        }

        memo[k][row][column] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top-Down - 6 ms
class Solution {
    int[][] dirs = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    double[][][] memo;

    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[k + 1][n][n];
        return getProb(n, k, row, column);
    }

    private double getProb(int n, int k, int row, int column) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }

        if (k == 0) {
            return 1.0;
        }

        if (memo[k][row][column] != 0.0) {
            return memo[k][row][column];
        }

        double res = 0.0;

        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = column + dir[1];
            res += getProb(n, k - 1, x, y) / 8.0;
        }

        memo[k][row][column] = res;
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