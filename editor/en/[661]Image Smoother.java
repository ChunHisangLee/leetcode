

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int[][] DIRS = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] arrs = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arrs[i][j] = getNum(img, i, j);
            }
        }

        return arrs;
    }

    private int getNum(int[][] img, int i, int j) {
        int sum = img[i][j];
        int count = 1;

        for (int[] dir : DIRS) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x >= 0 && x < img.length && y >= 0 && y < img[0].length) {
                count++;
                sum += img[x][y];
            }
        }

        return sum / count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
