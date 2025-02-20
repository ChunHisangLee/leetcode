
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    private static final int[][] DIRECTIONS = {
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int[][] board = new int[m][n];

        for (int[] row : board) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -1;
            }
        }

        board[r][c] = 0;

        if (solve(r, c, 1, board, m, n)) {
            return board;
        }

        return new int[][]{};
    }

    private boolean solve(int x, int y, int move, int[][] board, int m, int n) {
        if (move == m * n) {
            return true;
        }

        List<int[]> nextMoves = getNextMoves(x, y, board, m, n);
        nextMoves.sort(Comparator.comparingInt(a -> countOnwardMoves(a[0], a[1], board, m, n)));

        for (int[] movePos : nextMoves) {
            int nextX = movePos[0];
            int nextY = movePos[1];
            board[nextX][nextY] = move;

            if (solve(nextX, nextY, move + 1, board, m, n)) {
                return true;
            }

            board[nextX][nextY] = -1;
        }

        return false;
    }

    private List<int[]> getNextMoves(int x, int y, int[][] board, int m, int n) {
        List<int[]> moves = new ArrayList<>();

        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValid(newX, newY, board, m, n)) {
                moves.add(new int[]{newX, newY});
            }
        }

        return moves;
    }

    private int countOnwardMoves(int x, int y, int[][] board, int m, int n) {
        int count = 0;

        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (isValid(newX, newY, board, m, n)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(int x, int y, int[][] board, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n && board[x][y] == -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
