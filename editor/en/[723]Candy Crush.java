
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    int[][] arr;

    public int[][] candyCrush(int[][] board) {
        if (board.length == 0) {
            return board;
        }
        m = board.length;
        n = board[0].length;
        arr = new int[m][n];
        boolean needCrush = false;
        do {
            dropUncrushed(board);
            needCrush = crush(board);
        } while (needCrush);
        return board;
    }

    private boolean crush(int[][] board) {
        boolean needCrush = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (board[i][j] != 0 && board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2]) {
                    arr[i][j] = 1;
                    arr[i][j + 1] = 1;
                    arr[i][j + 2] = 1;
                    needCrush = true;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m - 2; i++) {
                if (board[i][j] != 0 && board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j]) {
                    arr[i][j] = 1;
                    arr[i + 1][j] = 1;
                    arr[i + 2][j] = 1;
                    needCrush = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    board[i][j] = 0;
                }
            }
        }
        return needCrush;
    }

    private void dropUncrushed(int[][] board) {
        for (int j = 0; j < n; j++) {
            int index = m - 1;
            for (int i = m - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    board[index--][j] = board[i][j];
                }
            }
            while (index >= 0) {
                board[index--][j] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
