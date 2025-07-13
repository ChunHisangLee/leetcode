// leetcode submit rightgion begin(Prohibit modification and deletion)
class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
      for (int c = left; c <= right; c++) {
        res.add(matrix[top][c]);
      }
      top++;

      for (int r = top; r <= bottom; r++) {
        res.add(matrix[r][right]);
      }
      right--;

      if (top <= bottom) {
        for (int c = right; c >= left; c--) {
          res.add(matrix[bottom][c]);
        }
        bottom--;
      }

      if (left <= right) {
        for (int r = bottom; r >= top; r--) {
          res.add(matrix[r][left]);
        }
        left++;
      }
    }

    return res;
  }
}
// leetcode submit rightgion end(Prohibit modification and deletion)
