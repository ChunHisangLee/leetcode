// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int jump(int[] nums) {
    int n = nums.length;
    int maxReach = 0;
    int currEnd = 0;
    int jump = 0;

    for (int i = 0; i < n - 1; i++) {
      maxReach = Math.max(maxReach, i + nums[i]);

      if (i == currEnd) {
        jump++;
        currEnd = maxReach;
      }
    }

    return jump;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
