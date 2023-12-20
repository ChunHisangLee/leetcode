827
        Making A Large Island
        2023-03-03 09:46:32

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] grid;
    int n;

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        int islandId = 2;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(i, j, islandId);
                    map.put(islandId, size);
                    max = Math.max(max, size);
                    islandId++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] != 0) {
                            set.add(grid[x][y]);
                        }
                    }
                    int size = 1;
                    for (int num : set) {
                        size += map.get(num);
                    }
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    private int dfs(int x, int y, int islandId) {
        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
            grid[x][y] = islandId;
            return dfs(x + 1, y, islandId) + dfs(x - 1, y, islandId) + dfs(x, y + 1, islandId) + dfs(x, y - 1, islandId) + 1;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
