
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        long count = 0;
        int left = 0;
        int freq = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                freq++;
            }

            while (freq >= k) {
                if (nums[left++] == max) {
                    freq--;
                }
            }

            count += left;
        }

        return count;
    }
}


//leetcode submit region right(Prohibit modification and deletion)
