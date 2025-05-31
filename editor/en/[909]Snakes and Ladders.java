// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    int N = n * n;
    boolean[] visited = new boolean[N + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(1);
    visited[1] = true;
    int moves = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int curr = queue.poll();
        if (curr == N) {
          return moves;
        }

        for (int die = 1; die <= 6; die++) {
          int nextLabel = curr + die;
          if (nextLabel > N) {
            break;
          }
          int row = getRow(nextLabel, n);
          int col = getCol(nextLabel, n);
          int dest = board[row][col] == -1 ? nextLabel : board[row][col];
          if (!visited[dest]) {
            visited[dest] = true;
            queue.offer(dest);
          }
        }
      }
      moves++;
    }
    return -1;
  }

  private int getRow(int label, int n) {
    int index = label - 1;
    int rowFromBottom = index / n;
    return n - 1 - rowFromBottom;
  }

  private int getCol(int label, int n) {
    int index = label - 1;
    int rowFromBottom = index / n;
    int colInRow = index % n;
    if (rowFromBottom % 2 == 0) {
      return colInRow;
    } else {
      return n - 1 - colInRow;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
