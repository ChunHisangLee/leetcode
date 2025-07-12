// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int count = 0;
    int indexG = 0;
    int indexS = 0;

    while (indexG < g.length && indexS < s.length) {
      if (g[indexG] <= s[indexS]) {
        count++;

        indexG++;
      }

      indexS++;
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
