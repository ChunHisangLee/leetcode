// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int numEquivDominoPairs(int[][] dominoes) {
    int[][] counts = new int[10][10];
    int result = 0;

    for (int[] domino : dominoes) {
      int a = domino[0];
      int b = domino[1];
      int x = Math.min(a, b);
      int y = Math.max(a, b);

      result += counts[x][y];
      counts[x][y]++;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
