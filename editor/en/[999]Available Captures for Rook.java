//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        int[] rookPos = findRook(board);
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] dir : dirs) {
            int x = rookPos[0] + dir[0];
            int y = rookPos[1] + dir[1];

            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == 'B') {
                    break;
                }

                if (board[x][y] == 'p') {
                    count++;
                    break;
                }

                x += dir[0];
                y += dir[1];
            }
        }

        return count;
    }

    private int[] findRook(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
