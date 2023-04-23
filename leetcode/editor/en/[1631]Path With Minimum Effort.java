1631
        Path With Minimum Effort
        2022-12-12 17:29:57

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = heights.length;
        int n = heights[0].length;
        int[][] arrs = new int[m][n];
        boolean[][] isVisited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] arr : arrs) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        arrs[0][0] = 0;
        pq.add(new int[]{0, 0, arrs[0][0]});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            isVisited[curr[0]][curr[1]] = true;
            if (curr[0] == m - 1 && curr[1] == n - 1) {
                return curr[2];
            }
            for (int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y]) {
                    continue;
                }
                int currDif = Math.abs(heights[x][y] - heights[curr[0]][curr[1]]);
                int maxDif = Math.max(currDif, curr[0]);
                if (maxDif < arrs[x][y]) {
                    arrs[x][y] = maxDif;
                    pq.add(new int[]{x, y, maxDif});
                }
            }
        }
        return arrs[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
