//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int minRow;
    private int minCol;
    private int maxRow;
    private int maxCol;

    public int[][] findFarmland(int[][] land) {
        List<int[]> farmlands = new ArrayList<>();
        int m = land.length;
        int n = land[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    minRow = i;
                    maxRow = i;
                    minCol = j;
                    maxCol = j;
                    dfs(land, i, j);
                    farmlands.add(new int[]{minRow, minCol, maxRow, maxCol});
                }
            }
        }

        return farmlands.toArray(new int[0][]);
    }

    private void dfs(int[][] land, int row, int col) {
        if (row < 0 || row >= land.length || col < 0 || col >= land[0].length || land[row][col] != 1) {
            return;
        }

        land[row][col] = 0;
        minRow = Math.min(minRow, row);
        maxRow = Math.max(maxRow, row);
        minCol = Math.min(minCol, col);
        maxCol = Math.max(maxCol, col);
        dfs(land, row - 1, col);
        dfs(land, row + 1, col);
        dfs(land, row, col - 1);
        dfs(land, row, col + 1);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
