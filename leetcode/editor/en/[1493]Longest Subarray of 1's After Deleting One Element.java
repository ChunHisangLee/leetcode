1493
        Longest Subarray of 1's After Deleting One Element
        2023-02-26 16:54:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        int prev = 0;
        int curr = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 1) {
                curr++;
            } else {
                res = Math.max(res, curr + prev);
                prev = curr;
                curr = 0;
            }
        }
        res = Math.max(res, curr + prev);
        return res == nums.length? res - 1 : res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
