// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int returnToBoundaryCount(int[] nums) {
    int count = 0;
    int sum = 0;

    for (int num : nums) {
      sum += num;

      if (sum == 0) {
        count++;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
