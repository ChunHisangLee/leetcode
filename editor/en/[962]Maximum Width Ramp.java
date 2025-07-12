
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }

            if (stack.isEmpty()) {
                break;
            }
        }

        return maxWidth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
