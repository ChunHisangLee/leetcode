
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                int z = 0;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    z++;
                }
                x -= dir[0];
                y -= dir[1];
                if (dist[curr[0]][curr[1]] + z < dist[x][y]) {
                    dist[x][y] = dist[curr[0]][curr[1]] + z;
                    dq.add(new int[]{x, y});
                }
            }
        }
        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS: - 377ms
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        dfs(maze, start, dist);
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] dist) {
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int z = 0;
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                z++;
            }
            x -= dir[0];
            y -= dir[1];
            if (dist[start[0]][start[1]] + z < dist[x][y]) {
                dist[x][y] = dist[start[0]][start[1]] + z;
                dfs(maze, new int[]{x, y}, dist);
            }
        }
    }
}


BFS: - 7ms
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                int z = 0;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    z++;
                }
                x -= dir[0];
                y -= dir[1];
                if (dist[curr[0]][curr[1]] + z < dist[x][y]) {
                    dist[x][y] = dist[curr[0]][curr[1]] + z;
                    dq.add(new int[]{x, y});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }
}

Dijkstra: -410ms
public class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] dist = new int[maze.length][maze[0].length];
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        dijkstra(maze, dist, isVisited);
        return dist[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : dist[dest[0]][dest[1]];
    }

    public int[] minDistance(int[][] dist, boolean[][] isVisited) {
        int[] min = {-1, -1};
        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                if (!isVisited[i][j] && dist[i][j] < min_val) {
                    min = new int[]{i, j};
                    min_val = dist[i][j];
                }
            }
        }
        return min;
    }

    public void dijkstra(int[][] maze, int[][] dist, boolean[][] isVisited) {
        while (true) {
            int[] s = minDistance(dist, isVisited);
            if (s[0] < 0)
                break;
            isVisited[s[0]][s[1]] = true;
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                if (dist[s[0]][s[1]] + count < dist[x - dir[0]][y - dir[1]]) {
                    dist[x - dir[0]][y - dir[1]] = dist[s[0]][s[1]] + count;
                }
            }
        }
    }
}
 */