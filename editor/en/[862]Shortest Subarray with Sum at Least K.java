
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (long) nums[i];
        }

        int result = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);

        for (int i = 1; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.peekFirst());
                deque.pollFirst();
            }

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return result <= n ? result : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
