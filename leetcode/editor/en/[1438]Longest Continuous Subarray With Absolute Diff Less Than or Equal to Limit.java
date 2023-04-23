1438
        Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
        2022-11-30 10:18:45

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> increasing = new ArrayDeque<>();
        ArrayDeque<Integer> decreasing = new ArrayDeque<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!increasing.isEmpty() && increasing.getLast() > nums[right]) {
                increasing.removeLast();
            }
            while (!decreasing.isEmpty() && decreasing.getLast() < nums[right]) {
                decreasing.removeLast();
            }
            increasing.addLast(nums[right]);
            decreasing.addLast(nums[right]);
            while (decreasing.getFirst() - increasing.getFirst() > limit) {
                if (nums[left] == decreasing.getFirst())
                    decreasing.removeFirst();
                if (nums[left] == increasing.getFirst())
                    increasing.removeFirst();
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
