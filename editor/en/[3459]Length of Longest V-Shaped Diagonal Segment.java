
//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
    private static final int[] DR = {+1, +1, -1, -1};
    private static final int[] DC = {+1, -1, -1, +1};
    private static final int[] CW = {1, 2, 3, 0};

    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] endAt = new int[4][n][m];
        int[][][] next2 = new int[4][n][m];
        int[][][] next0 = new int[4][n][m];

        for (int d = 0; d < 4; d++) {
            fillEndAtForDirection(grid, d, endAt[d]);
        }

        for (int d = 0; d < 4; d++) {
            fillNextAltForDirection(grid, d, next2[d], next0[d]);
        }

        int ans = 0;

        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    ans = Math.max(ans, endAt[d][i][j]);
                }
            }
        }

        for (int d = 0; d < 4; d++) {
            int cd = CW[d];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int L = endAt[d][i][j];
                    if (L <= 0) continue;

                    int ni = i + DR[cd], nj = j + DC[cd];
                    if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                        ans = Math.max(ans, L);
                        continue;
                    }

                    boolean need2 = (L % 2 == 1);
                    int tail = need2 ? next2[cd][ni][nj] : next0[cd][ni][nj];
                    ans = Math.max(ans, L + tail);
                }
            }
        }

        return ans;
    }

    private void fillEndAtForDirection(int[][] grid, int d, int[][] end) {
        int n = grid.length, m = grid[0].length;
        int dr = DR[d], dc = DC[d];
        List<int[]> starts = diagonalStarts(n, m, dr, dc);

        for (int[] s : starts) {
            int i = s[0], j = s[1];
            while (i >= 0 && i < n && j >= 0 && j < m) {
                int best = 0;
                if (grid[i][j] == 1) {
                    best = 1;
                }
                int pi = i - dr, pj = j - dc;
                if (pi >= 0 && pi < n && pj >= 0 && pj < m) {
                    int prev = end[pi][pj];
                    if (prev > 0) {
                        int expect = (prev % 2 == 1) ? 2 : 0;
                        if (grid[i][j] == expect) {
                            best = Math.max(best, prev + 1);
                        }
                    }
                }
                end[i][j] = best;
                i += dr;
                j += dc;
            }
        }
    }

    private void fillNextAltForDirection(int[][] grid, int d, int[][] n2, int[][] n0) {
        int n = grid.length, m = grid[0].length;
        int dr = DR[d], dc = DC[d];

        List<int[]> starts = diagonalEndsAsStarts(n, m, dr, dc);
        for (int[] s : starts) {
            int i = s[0], j = s[1];
            while (i >= 0 && i < n && j >= 0 && j < m) {
                if (grid[i][j] == 2) {
                    int ni = i + dr, nj = j + dc;
                    n2[i][j] = 1 + ((ni >= 0 && ni < n && nj >= 0 && nj < m) ? n0[ni][nj] : 0);
                } else {
                    n2[i][j] = 0;
                }
                if (grid[i][j] == 0) {
                    int ni = i + dr, nj = j + dc;
                    n0[i][j] = 1 + ((ni >= 0 && ni < n && nj >= 0 && nj < m) ? n2[ni][nj] : 0);
                } else {
                    n0[i][j] = 0;
                }
                i -= dr;
                j -= dc;
            }
        }
    }

    private List<int[]> diagonalStarts(int n, int m, int dr, int dc) {
        List<int[]> res = new ArrayList<>();
        if (dr == +1 && dc == +1) {
            for (int j = 0; j < m; j++) res.add(new int[]{0, j});
            for (int i = 1; i < n; i++) res.add(new int[]{i, 0});
        } else if (dr == +1 && dc == -1) {
            for (int j = 0; j < m; j++) res.add(new int[]{0, j});
            for (int i = 1; i < n; i++) res.add(new int[]{i, m - 1});
        } else if (dr == -1 && dc == -1) {
            for (int j = 0; j < m; j++) res.add(new int[]{n - 1, j});
            for (int i = 0; i < n - 1; i++) res.add(new int[]{i, m - 1});
        } else {
            for (int j = 0; j < m; j++) res.add(new int[]{n - 1, j});
            for (int i = 0; i < n - 1; i++) res.add(new int[]{i, 0});
        }
        return res;
    }

    private List<int[]> diagonalEndsAsStarts(int n, int m, int dr, int dc) {
        return diagonalStarts(n, m, -dr, -dc);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
