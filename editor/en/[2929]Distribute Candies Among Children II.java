// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public long distributeCandies(int n, int limit) {
    if (n > 3L * limit) {
      return 0L;
    }

    long ans = comb2(n + 2);

    if (n > limit) {
      ans -= 3L * comb2(n - limit + 1);
    }
    if (n - 2L >= 2L * limit) {
      ans += 3L * comb2(n - 2 * limit);
    }

    return ans;
  }

  private long comb2(long m) {
    return m * (m - 1) / 2;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
