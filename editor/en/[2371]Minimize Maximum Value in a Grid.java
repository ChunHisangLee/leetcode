
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        List<Cell> cells = new ArrayList<>();

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                cells.add(new Cell(r, c, grid[r][c]));
            }
        }

        Collections.sort(cells, Comparator.comparingInt(a -> a.value));
        int[] rowMax = new int[m];
        int[] colMax = new int[n];

        for(Cell cell : cells) {
            int newVal = Math.max(rowMax[cell.row], colMax[cell.col]) + 1;
            result[cell.row][cell.col] = newVal;
            rowMax[cell.row] = newVal;
            colMax[cell.col] = newVal;
        }

        return result;
    }

    class Cell {
        int row;
        int col;
        int value;

        Cell(int row, int col, int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
