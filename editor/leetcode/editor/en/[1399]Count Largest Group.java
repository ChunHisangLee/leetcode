// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countLargestGroup(int n) {
    int[] counts = new int[37];
    int maxCount = 0;

    for (int i = 1; i <= n; i++) {
      int sum = 0;
      int x = i;

      while (x > 0) {
        sum += x % 10;
        x /= 10;
      }

      counts[sum]++;
      maxCount = Math.max(maxCount, counts[sum]);
    }

    int result = 0;
    for (int c : counts) {
      if (c == maxCount) {
        result++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
