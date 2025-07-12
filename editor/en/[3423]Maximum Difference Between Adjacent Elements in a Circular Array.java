// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int maxAdjacentDistance(int[] nums) {
    int answer = Integer.MIN_VALUE;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      int diff = nums[i] - nums[(i + 1) % n];
      answer = Math.max(answer, Math.abs(diff));
    }

    return answer;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
