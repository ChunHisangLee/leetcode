
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> heap = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < m; i++) {
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            heap.offer(new Cell(0, j, heightMap[0][j]));
            heap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int water = 0;
        int maxHeight = 0;

        while (!heap.isEmpty()) {
            Cell cell = heap.poll();
            maxHeight = Math.max(maxHeight, cell.height);
            for (int[] dir : directions) {
                int ni = cell.x + dir[0];
                int nj = cell.y + dir[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    if (heightMap[ni][nj] < maxHeight) {
                        water += maxHeight - heightMap[ni][nj];
                    }
                    heap.offer(new Cell(ni, nj, Math.max(heightMap[ni][nj], maxHeight)));
                }
            }
        }

        return water;
    }

    class Cell {
        int x;
        int y;
        int height;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
