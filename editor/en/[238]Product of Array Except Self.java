//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int postfixSum = 1;
        answer[0] = 1;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            postfixSum *= nums[i + 1];
            answer[i] *= postfixSum;
        }

        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
