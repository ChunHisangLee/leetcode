
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int m;
    int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        m = board.length;
        n = board[0].length;
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'E') {
            return;
        }
        int mine = findMine(board, i, j);
        if (mine == 0) {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                dfs(board, x, y);
            }
        } else {
            board[i][j] = (char) (mine + '0');
        }
    }

    private int findMine(char[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
DFS -0ms
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    int m;
    int n;

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        m = board.length;
        n = board[0].length;
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'E') {
            return;
        }
        int mine = findMine(board, i, j);
        if (mine == 0) {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                dfs(board, x, y);
            }
        } else {
            board[i][j] = (char) (mine + '0');
        }
    }

    private int findMine(char[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (board[x][y] == 'M') {
                count++;
            }
        }
        return count;
    }
}

BFS - 4ms
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int m = board.length;
        int n = board[0].length;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(click);
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int i = curr[0];
            int j = curr[1];
            int mine = 0;
            if (board[i][j] == 'E') {
                List<int[]> list = new ArrayList<>();
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    char c = board[x][y];
                    if (c == 'M') {
                        mine++;
                    } else if (c == 'E') {
                        list.add(new int[]{x, y});
                    }
                }
                if (mine != 0) {
                    board[i][j] = (char) (mine + '0');
                } else {
                    board[i][j] = 'B';
                    for (int[] arr : list) {
                        dq.add(arr);
                    }
                }
            }
        }
        return board;
    }
}
 */