
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countSubarrays(int[] nums, long k) {
        if (k <= 1) {
            return 0;
        }
        long count = 0;
        long sum = 0;
        long prod = 0;
        int num = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            num = right - left + 1;
            sum += nums[right];
            prod = sum * num;
            while (prod >= k) {
                sum -= nums[left];
                left++;
                num = right - left + 1;
                prod = sum * num;
            }
            count += num;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
