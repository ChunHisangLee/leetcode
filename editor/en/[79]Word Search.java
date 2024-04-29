//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[][] board;
    boolean[][] isVisited;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Map<Character, Integer> map = new HashMap<>();
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
            }
        }

        for (char c : word.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            map.put(c, map.get(c) - 1);

            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    isVisited[i][j] = true;

                    if (backtrack(word, i, j, 1)) {
                        return true;
                    }

                    isVisited[i][j] = false;
                }
            }
        }

        return false;
    }

    public boolean backtrack(String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y] == true) {
                continue;
            }

            if (board[x][y] == word.charAt(index)) {
                isVisited[x][y] = true;

                if (backtrack(word, x, y, index + 1)) {
                    return true;
                }

                isVisited[x][y] = false;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
