// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countSubarrays(int[] nums) {
    int n = nums.length;
    int count = 0;

    for (int i = 0; i + 2 < n; i++) {
      int first = nums[i];
      int middle = nums[i + 1];
      int third = nums[i + 2];

      if (middle == 2 * (first + third)) {
        count++;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
