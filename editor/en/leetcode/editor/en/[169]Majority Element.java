// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int majorityElement(int[] nums) {
    int candidate = 0;
    int count = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }

      if (candidate == num) {
        count++;
      } else {
        count--;
      }
    }

    return candidate;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
