37
        Sudoku Solver
        2022-12-23 16:25:12

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] boxes = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int value = c - '1';
                    rows[i][value] = true;
                    cols[j][value] = true;
                    boxes[i / 3][j / 3][value] = true;
                }
            }
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) {
                return true;
            }
        }
        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }
        for (int value = 0; value < 9; value++) {
            if (rows[row][value] || cols[col][value] || boxes[row / 3][col / 3][value]) {
                continue;
            }
            board[row][col] = (char) (value + '1');
            rows[row][value] = true;
            cols[col][value] = true;
            boxes[row / 3][col / 3][value] = true;
            if (backtrack(board, row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
            rows[row][value] = false;
            cols[col][value] = false;
            boxes[row / 3][col / 3][value] = false;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
