
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final int[] DIRECTIONS = {0, 1, 0, -1, 0};

    public int numberOfCleanRooms(int[][] room) {
        int rows = room.length;
        int cols = room[0].length;
        int[][] visited = new int[rows][cols];
        int cleaned = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int direction = current[2];

            if (visited[row][col] == 0) {
                cleaned += 1;
            }

            visited[row][col] |= 1 << direction;

            for (int d = 0; d < 4; d++) {
                int nextDir = (direction + d) % 4;
                int nextRow = row + DIRECTIONS[nextDir];
                int nextCol = col + DIRECTIONS[nextDir + 1];

                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols && room[nextRow][nextCol] == 0) {
                    if ((visited[nextRow][nextCol] >> nextDir & 1) == 1) {
                        return cleaned;
                    } else {
                        queue.offer(new int[]{nextRow, nextCol, nextDir});
                        break;
                    }
                }
            }
        }

        return cleaned;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
