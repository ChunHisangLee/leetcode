1091
        Shortest Path in Binary Matrix
        2022-12-03 00:01:30

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[n][n];
        dq.add(new int[]{0, 0, 1});
        isVisited[0][0] = true;
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return curr[2];
            }
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1 || isVisited[x][y]) {
                    continue;
                }
                isVisited[x][y] = true;
                dq.add(new int[]{x, y, curr[2] + 1});
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
