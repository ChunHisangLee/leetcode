// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int total = 0;

    for (int point : cardPoints) {
      total += point;
    }

    if (k == n) {
      return total;
    }

    int windowSize = n - k;
    int left = 0;
    int currSum = 0;
    int maxSum = 0;

    for (int right = 0; right < n; right++) {
      currSum += cardPoints[right];

      if (right - left + 1 == n - k) {
        maxSum = Math.max(maxSum, total - currSum);
        currSum -= cardPoints[left];
        left++;
      }
    }

    return maxSum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
