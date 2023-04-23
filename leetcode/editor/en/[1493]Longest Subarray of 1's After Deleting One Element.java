1493
        Longest Subarray of 1's After Deleting One Element
        2023-02-26 16:54:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int prev = 0;
        int curr = 0;
        for (int num : nums) {
            if (num == 0) {
                prev = curr;
                curr = 0;
            } else {
                curr++;
                res = Math.max(res, prev + curr);
            }
        }
        return res == nums.length ? res - 1 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
