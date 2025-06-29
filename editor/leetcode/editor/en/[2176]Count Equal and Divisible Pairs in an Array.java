// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int countPairs(int[] nums, int k) {
    int n = nums.length;
    int count = 0;

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (nums[i] == nums[j] && (i * j) % k == 0) {
          count++;
        }
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
