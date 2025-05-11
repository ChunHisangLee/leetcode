// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public boolean threeConsecutiveOdds(int[] arr) {
    int oddCount = 0;

    for (int num : arr) {
      if (num % 2 == 1) {
        oddCount++;
      } else {
        oddCount = 0;
      }

      if (oddCount == 3) {
        return true;
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
