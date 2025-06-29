// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countLargestGroup(int n) {
    int MAX_SUM = 36;
    int[] counts = new int[MAX_SUM + 1];
    int[] digitSum = new int[n + 1];

    int maxCount = 0;
    int numAtMax = 0;

    for (int i = 1; i <= n; i++) {
      digitSum[i] = digitSum[i / 10] + (i % 10);

      int s = digitSum[i];
      counts[s]++;

      int c = counts[s];

      if (c > maxCount) {
        maxCount = c;
        numAtMax = 1;
      } else if (c == maxCount) {
        numAtMax++;
      }
    }

    return numAtMax;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
