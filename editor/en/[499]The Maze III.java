/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirN = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        String[] dirC = {"u", "r", "d", "l"};
        int[][] dist = new int[m][n];
        String[][] path = new String[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(ball);
        dist[ball[0]][ball[1]] = 0;
        path[ball[0]][ball[1]] = "";
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int i = 0; i < 4; ++i) {
                int x = curr[0] + dirN[i][0];
                int y = curr[1] + dirN[i][1];
                int z = 1;
                boolean isHole = false;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    if (x == hole[0] && y == hole[1]) {
                        isHole = true;
                    }
                    x += dirN[i][0];
                    y += dirN[i][1];
                    z++;
                    if (isHole) {
                        break;
                    }
                }
                String dir = dirC[i];
                z--;
                if (z == 0) {
                    continue;
                }
                x -= dirN[i][0];
                y -= dirN[i][1];
                if (dist[x][y] > dist[curr[0]][curr[1]] + z) {
                    dist[x][y] = dist[curr[0]][curr[1]] + z;
                    path[x][y] = path[curr[0]][curr[1]] + dir;
                    dq.add(new int[]{x, y});
                } else if (dist[x][y] == dist[curr[0]][curr[1]] + z) {
                    if (path[x][y].compareTo(path[curr[0]][curr[1]] + z) > 0) {
                        dq.add(new int[]{x, y});
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dist[i]));
            System.out.println(Arrays.toString(path[i]));
        }
        return path[hole[0]][hole[1]] == null ? "impossible" : path[hole[0]][hole[1]];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
