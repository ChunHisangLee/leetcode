
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] arr = new int[row][col];
        for (int[] cell : cells) {
            grid[cell[0] - 1][cell[1] - 1] = 1;
        }
        UnionFind uf = new UnionFind(row * col + 2);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 1) {
                            continue;
                        }
                        uf.union(i * col + j, x * col + y);
                    }
                }
            }
        }
        for (int i = 0; i < col; i++) {
            uf.union(row * col, i);
            uf.union(row * col + 1, (row - 1) * col + i);
        }
        for (int c = row * col - 1; c >= 0; c--) {
            int i = cell[c][0] - 1;
            int j = cell[c][1] - 1;
            grid[x][y] = 0;
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 1) {
                    continue;
                }
                uf.union(i * col + j, x * col + y);
            }
            if (uf.isConnected(row * col, row * col + 1)) {
                return i;
            }
        }
        return 0;
    }
}

class UnionFind {
    private ing[] group;

    public UnionFind(int n) {
        group = new ing[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    public inf find(int x) {
        return group(x) == x ? x : (group(x) = find(x));
    }

    private boolean union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x]] =y;
            return true;
        }
        return false;
    }

    private boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
