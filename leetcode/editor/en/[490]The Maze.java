
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] isisVisited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        isisVisited[start[0]][start[1]] = true;
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (!isisVisited[x][y]) {
                    dq.add(new int[]{x, y});
                    isisVisited[x][y] = true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS: -2ms
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m;
    int n;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        boolean[][] isVisited = new boolean[m][n];
        return dfs(maze, start[0], start[1], isVisited, destination[0], destination[1]);
    }

    public boolean dfs(int[][] maze, int i, int j, boolean[][] isVisited, int dx, int dy) {
        boolean res = false;
        if (i == dx && j == dy) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || isVisited[i][j]) {
            return false;
        }
        isVisited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            if (dfs(maze, x - dir[0], y - dir[1], isVisited, dx, dy)) {
                return true;
            }
        }
        return res;
    }
}

BFS: - 4ms
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] isisVisited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);
        isisVisited[start[0]][start[1]] = true;
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                if (!isisVisited[x][y]) {
                    dq.add(new int[]{x, y});
                    isisVisited[x][y] = true;
                }
            }
        }
        return false;
    }
}
 */