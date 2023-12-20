1631
        Path With Minimum Effort
        2022-12-12 17:29:57

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int[][] arrs = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int[] arr : arrs) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        arrs[0][0] = 0;
        pq.add(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            isVisited[i][j] = true;

            if (i == m - 1 && j == n - 1) {
                return curr[2];
            }

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y]) {
                    continue;
                }

                int diff = Math.abs(heights[x][y] - heights[i][j]);
                int max = Math.max(diff, curr[2]);

                if (max < arrs[x][y]) {
                    arrs[x][y] = max;
                    pq.add(new int[]{x, y, max});
                }
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
