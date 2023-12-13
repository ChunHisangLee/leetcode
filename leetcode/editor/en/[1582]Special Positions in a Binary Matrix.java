
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (checkCol(mat, i, j) && checkRow(mat, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean checkRow(int[][] mat, int r, int c) {
        for (int i = 0; i < mat.length; i++) {
            if (i == r) {
                continue;
            }

            if (mat[i][c] == 1) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCol(int[][] mat, int r, int c) {
        for (int i = 0; i < mat[0].length; i++) {
            if (i == c) {
                continue;
            }

            if (mat[r][i] == 1) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
