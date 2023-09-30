
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }

            while (!dq.isEmpty() && dq.peek() < nums[i]) {
                second = dq.pop();
            }

            dq.push(nums[i]);
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
