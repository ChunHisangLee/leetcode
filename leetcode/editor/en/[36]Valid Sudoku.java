36
        Valid Sudoku
        2022-12-30 23:36:44

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> block = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && row.contains(board[i][j])) {
                    return false;
                }
                row.add(board[i][j]);
                if (board[j][i] != '.' && col.contains(board[j][i])) {
                    return false;
                }
                col.add(board[j][i]);
                int x = (i / 3) * 3 + j / 3;
                int y = (i % 3) * 3 + j % 3;
                if (board[x][y] != '.' && block.contains(board[x][y])) {
                    return false;
                }
                block.add(board[x][y]);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
