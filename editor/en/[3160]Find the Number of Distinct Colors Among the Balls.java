// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[] queryResults(int limit, int[][] queries) {
    int n = queries.length;
    int[] result = new int[n];

    Map<Integer, Integer> ballToColor = new HashMap<>();
    Map<Integer, Integer> colorCount = new HashMap<>();

    for (int i = 0; i < n; i++) {
      int ball = queries[i][0];
      int newColor = queries[i][1];

      if (ballToColor.containsKey(ball)) {
        int oldColor = ballToColor.get(ball);
        if (oldColor != newColor) {
          colorCount.put(oldColor, colorCount.get(oldColor) - 1);
          if (colorCount.get(oldColor) == 0) {
            colorCount.remove(oldColor);
          }

          ballToColor.put(ball, newColor);
          colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);
        }
      } else {
        ballToColor.put(ball, newColor);
        colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);
      }

      result[i] = colorCount.size();
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
