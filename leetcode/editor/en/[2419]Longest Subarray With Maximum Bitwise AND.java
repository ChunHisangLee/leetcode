
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0;
        int count = 0;
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int num : nums) {
            if (num == max) {
                count++;
                result = Math.max(result, count);
            } else {
                count = 0;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
