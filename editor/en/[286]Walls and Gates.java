286
        Walls and Gates
        2022-12-20 10:57:04

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    queue.add(new int[]{row, col});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n || rooms[nextRow][nextCol] != EMPTY) {
                    continue;
                }
                rooms[nextRow][nextCol] = rooms[row][col] + 1;
                queue.add(new int[]{nextRow, nextCol});
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
