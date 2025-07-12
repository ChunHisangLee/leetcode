// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if (image[sr][sc] != color) {
      dfs(image, sr, sc, image[sr][sc], color);
    }

    return image;
  }

  private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
    if (row < 0
        || row >= image.length
        || col < 0
        || col >= image[0].length
        || image[row][col] != originalColor) {
      return;
    }

    image[row][col] = newColor;

    dfs(image, row + 1, col, originalColor, newColor);
    dfs(image, row - 1, col, originalColor, newColor);
    dfs(image, row, col + 1, originalColor, newColor);
    dfs(image, row, col - 1, originalColor, newColor);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
