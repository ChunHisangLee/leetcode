// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int punishmentNumber(int n) {
    int result = 0;
    for (int i = 0; i <= n; i++) {
      String squareStr = String.valueOf(i * i);

      if (canPartition(squareStr, 0, 0, i)) {
        result += i * i;
      }
    }

    return result;
  }

  private boolean canPartition(String s, int start, int currentSum, int target) {
    if (start == s.length()) {
      return currentSum == target;
    }

    int num = 0;

    for (int end = start; end < s.length(); end++) {
      num = num * 10 + (s.charAt(end) - '0');

      if (currentSum + num > target) {
        break;
      }

      if (canPartition(s, end + 1, currentSum + num, target)) {
        return true;
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
