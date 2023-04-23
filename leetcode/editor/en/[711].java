711
        Number of Distinct Islands II
        2023-03-02 14:38:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    int[][] grid;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numDistinctIslands2(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    Deque<int[]> dq = new ArrayDeque<>();
                    List<int[]> list = new ArrayList<>();
                    dq.add(new int[]{i, j});
                    dfs(dq, list);
                    set.add(pattern(list));
                }
            }
        }
        return set.size();
    }

    private void dfs(Deque<int[]> dq, List<int[]> list) {
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            list.add(curr);
            for (int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    grid[x][y] = 0;
                    dq.add(new int[]{x, y});
                }
            }
        }
    }

    private String pattern(List<int[]> list) {
        int[][][] arrs = new int[8][list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            arrs[0][i] = new int[]{x, y};
            arrs[1][i] = new int[]{-x, y};
            arrs[2][i] = new int[]{x, -y};
            arrs[3][i] = new int[]{-x, -y};
            arrs[4][i] = new int[]{y, x};
            arrs[5][i] = new int[]{-y, x};
            arrs[6][i] = new int[]{y, -x};
            arrs[7][i] = new int[]{-y, -x};
        }

        String[] shapes = new String[8];
        for (int i = 0; i < 8; i++) {
            int[][] points = arrs[i];
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            for (int[] point : points) {
                minX = Math.min(minX, point[0]);
                minY = Math.min(minY, point[1]);
            }
            for (int[] point : points) {
                point[0] -= minX;
                point[1] -= minY;
            }
            Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            StringBuilder sb = new StringBuilder();
            for (int[] point : points) {
                sb.append('(').append(point[0]).append(',').append(point[1]).append(')');
            }
            shapes[i] = sb.toString();
        }
        Arrays.sort(shapes);
        return shapes[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
