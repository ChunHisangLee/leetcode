1004
        Max Consecutive Ones III
        2022-11-24 14:19:35

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int res = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                dq.add(right);
                if (dq.size() > k) {
                    res = Math.max(res, right - left);
                    left = dq.remove() + 1;
                }
            }
        }
        return Math.max(res, n - left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
