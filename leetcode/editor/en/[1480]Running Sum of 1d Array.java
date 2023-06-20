1480
        Running Sum of 1dArray
        2022-12-05 18:04:35

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            arr[i - 1] = preSum[i];
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
