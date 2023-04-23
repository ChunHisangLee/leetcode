1926
        Nearest Exit from Entrance in Maze
        2022-12-07 22:27:39

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int startX = entrance[0];
        int startY = entrance[1];
        maze[startX][startY] = '+';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        while (!queue.isEmpty()) {
            int[] currState = queue.poll();
            int currX = currState[0];
            int currY = currState[1];
            int currDist = currState[2];

            for (int[] dir : dirs) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if (0 <= nextX && nextX < row && 0 <= nextY && nextY < col && maze[nextX][nextY] == '.') {
                    if (nextX == 0 || nextX == row - 1 || nextY == 0 || nextY == col - 1)
                        return currDist + 1;
                    maze[nextX][nextY] = '+';
                    queue.offer(new int[]{nextX, nextY, currDist + 1});
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
