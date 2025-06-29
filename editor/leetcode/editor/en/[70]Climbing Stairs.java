// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int[] result = new int[n + 1];
    result[1] = 1;
    result[2] = 2;

    for (int i = 3; i <= n; i++) {
      result[i] = result[i - 1] + result[i - 2];
    }

    return result[n];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
