542
        01Matrix
        2022-12-21 16:01:06

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = mat.length;
        int n = mat[0].length;
        int[][] arr = new int[m][n];
        for (int[] list : arr) {
            Arrays.fill(list, Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    arr[i][j] = 0;
                    dq.add(new int[]{i, j});
                }
            }
        }
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (arr[x][y] > arr[curr[0]][curr[1]] + 1) {
                        arr[x][y] = arr[curr[0]][curr[1]] + 1;
                        dq.add(new int[]{x, y});
                    }
                }
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)