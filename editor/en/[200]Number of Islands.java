//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
1.DFS
class Solution {
    char[][] grid;
    int m;
    int n;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}

2.BFS
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0';
                    dq.add(new int[]{i, j});
                    while (!dq.isEmpty()) {
                        int[] curr = dq.poll();
                        for (int[] dir : dirs) {
                            int x = curr[0] + dir[0];
                            int y = curr[1] + dir[1];
                            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
                                continue;
                            }
                            dq.add(new int[]{x, y});
                            grid[x][y] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}

3.Union Find
class Solution {
    public int numIslands(char[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
                            continue;
                        }
                        uf.union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return uf.getCount();
    }
}

class UnionFind {
    int[] group;
    int count;

    public UnionFind(char[][] grid) {
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        group = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    group[i * n + j] = i * n + j;
                }
            }
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
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

 */