// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private int rows;
  private int cols;

  public boolean exist(char[][] board, String word) {
    rows = board.length;
    cols = board[0].length;

    int[] freqBoard = new int[128];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        freqBoard[board[r][c]]++;
      }
    }

    int[] freqWord = new int[128];
    for (char c : word.toCharArray()) {
      freqWord[c]++;
      if (freqWord[c] > freqBoard[c]) {
        return false;
      }
    }

    if (freqBoard[word.charAt(0)] > freqBoard[word.charAt(word.length() - 1)]) {
      word = new StringBuilder(word).reverse().toString();
    }

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (backtrack(board, word, r, c, 0)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean backtrack(char[][] board, String word, int r, int c, int index) {
    if (index == word.length()) {
      return true;
    }

    if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != word.charAt(index)) {
      return false;
    }

    char temp = board[r][c];
    board[r][c] = '#';

    for (int[] d : DIRS) {
      int nr = r + d[0];
      int nc = c + d[1];

      if (backtrack(board, word, nr, nc, index + 1)) {
        return true;
      }
    }

    board[r][c] = temp;
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
