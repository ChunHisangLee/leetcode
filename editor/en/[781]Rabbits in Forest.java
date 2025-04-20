// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int numRabbits(int[] answers) {
    int result = 0;
    int[] remain = new int[1001];

    for (int x : answers) {
      if (remain[x] > 0) {
        remain[x]--;
      } else {
        result += (x + 1);
        remain[x] = x;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
