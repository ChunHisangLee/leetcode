// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
          if (board[r][c] == 'O') {
            dfs(board, r, c);
          }
        }
      }
    }

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] == 'O') {
          board[r][c] = 'X';
        } else if (board[r][c] == 'T') {
          board[r][c] = 'O';
        }
      }
    }
  }

  private void dfs(char[][] board, int row, int col) {
    if (row < 0
        || row >= board.length
        || col < 0
        || col >= board[0].length
        || board[row][col] != 'O') {
      return;
    }

    board[row][col] = 'T';

    dfs(board, row - 1, col);
    dfs(board, row + 1, col);
    dfs(board, row, col - 1);
    dfs(board, row, col + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
