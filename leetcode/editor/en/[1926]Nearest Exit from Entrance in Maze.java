1926
        Nearest Exit from Entrance in Maze
        2022-12-07 22:27:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = maze.length;
        int n = maze[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int count = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == '+') {
                        continue;
                    }
                    if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                        return count;
                    }
                    dq.add(new int[]{x, y});
                    maze[x][y] = '+';
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
