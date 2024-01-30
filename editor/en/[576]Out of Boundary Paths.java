//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }

        final int MOD = (int) 1e9 + 7;
        int[][][] dp = new int[m][n][maxMove + 1];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        dp[startRow][startColumn][0] = 1;
        int count = 0;

        for (int move = 1; move <= maxMove; move++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];

                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            count = (count + dp[i][j][move - 1]) % MOD;
                        } else {
                            dp[x][y][move] = (dp[x][y][move] + dp[i][j][move - 1]) % MOD;
                        }
                    }
                }
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    private int[][][] dp;
    final int MOD = (int) 1e9 + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];

        for (int[][] A : dp) {
            for (int[] B : A) {
                Arrays.fill(B, -1);
            }
        }

        return solve(m, n, maxMove, startRow, startColumn);
    }

    private int solve(int m, int n, int move, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 1;
        }

        if (move == 0) {
            return 0;
        }

        if (dp[x][y][move] != -1) {
            return dp[x][y][move];
        }

        dp[x][y][move] = (
                (solve(m, n, move - 1, x - 1, y) + solve(m, n, move - 1, x + 1, y)) % MOD +
                        (solve(m, n, move - 1, x, y - 1) + solve(m, n, move - 1, x, y + 1)) % MOD
        ) % MOD;

        return dp[x][y][move];
    }
}

class Solution {
    final int MOD = (int) 1e9 + 7;
    int[][][] dp;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }

        dp = new int[m][n][maxMove + 1];
        dp[startRow][startColumn][0] = 1;
        int count = 0;

        for (int move = 1; move <= maxMove; move++) {
            count = countPath(m, n, move, count);
        }

        return count;
    }

    private int countPath(int m, int n, int move, int count) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    count = getCount(m, n, move, count, i, j, x, y);
                }
            }
        }

        return count;
    }

    private int getCount(int m, int n, int move, int count, int i, int j, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            count = (count + dp[i][j][move - 1]) % MOD;
        } else {
            dp[x][y][move] = (dp[x][y][move] + dp[i][j][move - 1]) % MOD;
        }
        return count;
    }
}

 */