
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = box[i][j];
            }
        }

        for (int j = 0; j < m; j++) {
            int pointer = n - 1;

            for (int i = n - 1; i >= 0; i--) {
                if (rotated[i][j] == '*') {
                    pointer = i - 1;
                } else if (rotated[i][j] == '#') {
                    rotated[i][j] = '.';
                    rotated[pointer][j] = '#';
                    pointer--;
                }
            }
        }

        return rotated;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
