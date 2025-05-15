
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sumIndices = new int[2 * n + 1];
        Arrays.fill(sumIndices, -2);
        sumIndices[n] = -1;
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 0) ? -1 : 1;

            int shiftedSum = sum + n;

            if (sumIndices[shiftedSum] == -2) {
                sumIndices[shiftedSum] = i;
            } else {
                maxLen = Math.max(maxLen, i - sumIndices[shiftedSum]);
            }
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
