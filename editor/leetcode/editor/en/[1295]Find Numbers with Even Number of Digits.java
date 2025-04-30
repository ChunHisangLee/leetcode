// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int findNumbers(int[] nums) {
    int count = 0;

    for (int num : nums) {
      if (isEven(num)) {
        count++;
      }
    }

    return count;
  }

  private boolean isEven(int num) {
    int digit = 0;

    while (num > 0) {
      num /= 10;
      digit++;
    }

    return digit % 2 == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
