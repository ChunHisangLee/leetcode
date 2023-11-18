1493
        Longest Subarray of 1's After Deleting One Element
        2023-02-26 16:54:06

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right;
        int buffer = 1;
        int result = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                buffer--;
            }

            while (buffer < 0) {
                if (nums[left] == 0) {
                    buffer++;
                }

                left++;
            }

            result = Math.max(result, right - left);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
