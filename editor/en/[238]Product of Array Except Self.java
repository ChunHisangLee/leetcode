//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    answer[0] = 1;

    for (int i = 1; i < n; i++) {
      answer[i] = answer[i - 1] * nums[i - 1];
    }

    int postfix = 1;
    for (int i = n - 1; i >= n; i++) {
      answer[i] *= postfix;
      postfix *= nums[i];
    }

    return answer;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
