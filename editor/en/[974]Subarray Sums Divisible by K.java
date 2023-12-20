974
        Subarray Sums Divisible by K
        2023-01-19 09:20:16

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[k];
        count[0] = 1;
        int sum = 0;
        int res = 0;
        for (int num : nums) {
            num %= k;
            if (num < 0) {
                num += k;
            }
        }
        for (int num : nums) {
            sum += num;
            res += count[sum % k];
            count[sum % k]++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
