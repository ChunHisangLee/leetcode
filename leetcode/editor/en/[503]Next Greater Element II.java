503
Next Greater Element II
2022-12-04 17:45:49
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && nums[dq.peek()] <= nums[i % n]) {
                dq.pop();
            }
            arr[i % n] = dq.isEmpty() ? -1 : nums[dq.peek()];
            dq.push(i % n);
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
