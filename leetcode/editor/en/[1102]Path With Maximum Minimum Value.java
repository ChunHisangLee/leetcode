1102
        Path With Maximum Minimum Value
        2023-02-14 15:43:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[b[0]][b[1]] - grid[a[0]][a[1]]);
        pq.add(new int[]{0, 0});
        int res = grid[0][0];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            res = Math.min(res, grid[curr[0]][curr[1]]);
            if (curr[0] == m - 1 && curr[1] == n - 1) {
                break;
            }
            for (int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y]) {
                    continue;
                }
                pq.add(new int[]{x, y});
                isVisited[x][y] = true;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
