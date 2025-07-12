
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        if (m == 0) return -1;
        int n = grid[0].length;
        if (n == 0) return -1;

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        Deque<int[]> deque = new LinkedList<>();
        deque.offerFirst(new int[]{0, 0});

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0];
            int y = current[1];

            if (x == m - 1 && y == n - 1) {
                return dist[x][y];
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    int newCost = dist[x][y] + grid[newX][newY];

                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        if (grid[newX][newY] == 0) {
                            deque.offerFirst(new int[]{newX, newY});
                        } else {
                            deque.offerLast(new int[]{newX, newY});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
