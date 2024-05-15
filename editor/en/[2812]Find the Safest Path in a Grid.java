
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] distToThief = new int[n][n];

        for (int[] row : distToThief) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    queue.add(new int[]{r, c});
                    distToThief[r][c] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && distToThief[nr][nc] == Integer.MAX_VALUE) {
                    distToThief[nr][nc] = distToThief[r][c] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        int left = 0, right = n * 2;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (canReachWithSafenessFactor(grid, distToThief, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canReachWithSafenessFactor(List<List<Integer>> grid, int[][] distToThief, int safenessFactor) {
        int n = grid.size();

        if (distToThief[0][0] < safenessFactor || distToThief[n - 1][n - 1] < safenessFactor) {
            return false;
        }

        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            if (r == n - 1 && c == n - 1) {
                return true;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && distToThief[nr][nc] >= safenessFactor) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
