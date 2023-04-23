909
        Snakes and Ladders
        2023-01-24 12:00:40

//leetcode submit region begin(Prohibit modification and deletion)
/*
還不會
 */
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        boolean[] isVisited = new boolean[n * n + 1];
        for (int move = 0; !dq.isEmpty(); move++) {
            for (int size = dq.size(); size > 0; size--) {
                int num = dq.poll();
                if (isVisited[num]) {
                    continue;
                }
                isVisited[num] = true;
                if (num == n * n) {
                    return move;
                }
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue(board, next);
                    if (value > 0) {
                        next = value;
                    }
                    if (!isVisited[next]) {
                        dq.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
