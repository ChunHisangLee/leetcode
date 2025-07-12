// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int numberOfAlternatingGroups(int[] colors, int k) {
    int n = colors.length;
    int[] breaks = new int[n];

    for (int i = 0; i < n; i++) {
      if (colors[i] == colors[(i + 1) % n]) {
        breaks[i] = 1;
      }
    }

    int[] prefix = new int[n + k + 1];

    for (int i = 0; i < n + k; i++) {
      prefix[i + 1] = prefix[i] + breaks[i % n];
    }

    int result = 0;

    for (int s = 0; s < n; s++) {
      int sumBreaks = prefix[s + (k - 1)] - prefix[s];
      if (sumBreaks == 0) {
        result++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
