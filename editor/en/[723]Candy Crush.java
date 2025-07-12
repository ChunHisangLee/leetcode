
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0) {
            return board;
        }

        int m = board.length;
        int n = board[0].length;
        boolean changed;

        do {
            changed = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.abs(board[i][j]);

                    if (val == 0) {
                        continue;
                    }

                    if (j + 2 < n && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        board[i][j] = -val;
                        board[i][j + 1] = -val;
                        board[i][j + 2] = -val;
                        changed = true;
                    }

                    if (i + 2 < m && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        board[i][j] = -val;
                        board[i + 1][j] = -val;
                        board[i + 2][j] = -val;
                        changed = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] < 0) {
                        board[i][j] = 0;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int writeRow = m - 1;

                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] > 0) {
                        board[writeRow][j] = board[i][j];

                        if (writeRow != i) {
                            board[i][j] = 0;
                        }

                        writeRow--;
                    }
                }

                while (writeRow >= 0) {
                    board[writeRow][j] = 0;
                    writeRow--;
                }
            }

        } while (changed);

        return board;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
