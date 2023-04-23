317
        Shortest Distance from All Buildings
        2022-12-07 23:20:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestDistance(int[][] grid) {
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] total = new int[rows][cols];
        int emptyLandValue = 0;
        int minDist = Integer.MAX_VALUE;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (grid[row][col] == 1) {
                    minDist = Integer.MAX_VALUE;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});
                    int steps = 0;
                    while (!queue.isEmpty()) {
                        steps++;
                        for (int level = queue.size(); level > 0; --level) {
                            int[] curr = queue.poll();
                            for (int[] dir : dirs) {
                                int nextRow = curr[0] + dir[0];
                                int nextCol = curr[1] + dir[1];
                                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == emptyLandValue) {
                                    grid[nextRow][nextCol]--;
                                    total[nextRow][nextCol] += steps;
                                    queue.offer(new int[]{nextRow, nextCol});
                                    minDist = Math.min(minDist, total[nextRow][nextCol]);
                                }
                            }
                        }
                    }
                    emptyLandValue--;
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
