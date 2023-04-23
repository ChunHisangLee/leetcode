268
        Missing Number
        2022-11-26 00:44:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] - i;
        }
        return n - sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
