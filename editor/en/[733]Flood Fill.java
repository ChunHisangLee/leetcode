733
        Flood Fill
        2022-12-21 15:49:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] image;
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        m = image.length;
        n = image[0].length;
        if (image[sr][sc] != color) {
            dfs(sr, sc, image[sr][sc], color);
        }
        return image;
    }

    public void dfs(int i, int j, int oldColor, int color) {
        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != oldColor) {
            return;
        }
        image[i][j] = color;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, oldColor, color);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
