
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        long count = 0;
        int start = 0;
        int freq = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == max) {
                freq++;
            }

            while (freq >= k) {
                count += nums.length - end;
                if (nums[start] == max) {
                    freq--;
                }

                start++;
            }
        }

        return count;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
