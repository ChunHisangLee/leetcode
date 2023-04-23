733
        Flood Fill
        2022-12-21 15:49:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        if (x + 1 < m) {
            dfs(image, x + 1, y, oldColor, newColor);
        }
        if (x > 0) {
            dfs(image, x - 1, y, oldColor, newColor);
        }
        if (y + 1 < n) {
            dfs(image, x, y + 1, oldColor, newColor);
        }
        if (y > 0) {
            dfs(image, x, y - 1, oldColor, newColor);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
