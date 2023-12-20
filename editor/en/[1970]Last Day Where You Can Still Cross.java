
//leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        UnionFind uf = new UnionFind(row * col + 2);
        int[][] grid = new int[row][col];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < row * col; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
            int index1 = r * col + c + 1;
            for (int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];
                int index2 = x * col + y + 1;
                if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) {
                    continue;
                }
                uf.union(index1, index2);
            }
            if (c == 0) {
                uf.union(0, index1);
            }
            if (c == col - 1) {
                uf.union(row * col + 1, index1);
            }
            if (uf.find(0) == uf.find(row * col + 1)) {
                return i;
            }
        }
        return -1;
    }
}
class UnionFind {
    int[] group;

    public UnionFind(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
        }
    }

    public int find(int x) {
        return group[x] == x ? x : (group[x] = find(group[x]));
    }

    public void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            group[x] = y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
