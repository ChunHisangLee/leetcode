
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + gain[i - 1];
        }
        int max = Integer.MIN_VALUE;
        for (int num : preSum) {
            max = Math.max(max, num);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
