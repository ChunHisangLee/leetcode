
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        long count = 0;
        int left = 0;
        int freq = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                freq++;
            }

            while (freq >= k) {
                count += (n - right);

                if (nums[left++] == max) {
                    freq--;
                }
            }
        }

        return count;
    }
}


//leetcode submit region right(Prohibit modification and deletion)
