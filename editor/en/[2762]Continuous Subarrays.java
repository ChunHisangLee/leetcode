
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(nums[right]);

            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }

            minDeque.offerLast(nums[right]);

            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > 2) {
                if (nums[left] == maxDeque.peekFirst()) {
                    maxDeque.pollFirst();
                }

                if (nums[left] == minDeque.peekFirst()) {
                    minDeque.pollFirst();
                }

                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
