
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int validSubarrays(int[] nums) {
        int result = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[i] < nums[dq.peek()]) {
                result += (i - dq.peek());
                dq.pop();
            }
            dq.push(i);
        }

        while (!dq.isEmpty()) {
            result += (nums.length - dq.peek());
            dq.pop();
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
