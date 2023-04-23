348
        Design Tic-Tac-Toe
        2023-01-12 20:25:02

//leetcode submit region begin(Prohibit modification and deletion)
class TicTacToe {
    int[][] grid;
    int n;

    public TicTacToe(int n) {
        grid = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        grid[row][col] = player;
        if (chkRow(row, player) || chkCol(col, player) || (row == col && chkDiag(player)) || (row + col == n - 1 && chkAntiDiag(player))) {
            return player;
        }
        return 0;
    }

    public boolean chkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (grid[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    public boolean chkCol(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (grid[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    public boolean chkDiag(int player) {
        for (int row = 0; row < n; row++) {
            if (grid[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    public boolean chkAntiDiag(int player) {
        for (int row = 0; row < n; row++) {
            if (grid[row][n - 1 - row] != player) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
//leetcode submit region end(Prohibit modification and deletion)
