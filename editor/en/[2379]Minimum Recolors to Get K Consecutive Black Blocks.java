// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int minimumRecolors(String blocks, int k) {
    int n = blocks.length();
    int count = 0;

    for (int i = 0; i < k; i++) {
      if (blocks.charAt(i) == 'W') {
        count++;
      }
    }

    int minCount = count;

    for (int i = k; i < n; i++) {
      if (blocks.charAt(i) == 'W') {
        count++;
      }

      if (blocks.charAt(i - k) == 'W') {
        count--;
      }

      minCount = Math.min(minCount, count);
    }

    return minCount;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
